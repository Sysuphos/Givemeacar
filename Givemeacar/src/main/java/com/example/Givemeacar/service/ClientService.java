package com.example.Givemeacar.service;

import com.example.Givemeacar.exception.ResourceNotFoundException;
import com.example.Givemeacar.model.Client;
import com.example.Givemeacar.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClientService {

    @Autowired // find what need to be injected
    //myInterface myBean
    private ClientRepository clientRepository;

    //get all clients
    public List<Client> getALLClient(){
        return clientRepository.findAll();
    }
    //create client
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }
    //get client by id
    public ResponseEntity<Client> getClientsById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client not exist with id : " + id));

        return ResponseEntity.ok(client);
    }

    //update client
    public ResponseEntity<Client> updateClient( Long id, Client clientDetails){
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not exist with id : " + id));

        client.setFirstName(clientDetails.getFirstName());
        client.setLastName(clientDetails.getLastName());
        client.setEmail(clientDetails.getEmail());
        client.setPhone(clientDetails.getPhone());
        client.setCity(clientDetails.getCity());
        client.setAdress(clientDetails.getAdress());

        Client updatedClient = clientRepository.save(client);
        return ResponseEntity.ok(updatedClient);
    }

    //delete client
    public ResponseEntity<Map<String, Boolean>> deleteClient(Long id){
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not exist with id : " + id));

        clientRepository.delete(client);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);

    }
}
