package com.example.Givemeacar.controller;

import com.example.Givemeacar.model.Client;
import com.example.Givemeacar.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class ClientController {

    @Autowired // find what need to be injected
    //myInterface myBean
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    //get all client
    @GetMapping("/clients")
    public List<Client> getALLClient(){
        return clientService.getALLClient();
    }
    //create client
    @PostMapping("/clients")
    public void createClient(@RequestBody Client client) {
        clientService.createClient(client);
    }
    //get client by id
    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClientsById(@PathVariable Long id) {
        return clientService.getClientsById(id);
    }
    //update client
    @PutMapping("/clients/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client clientDetails){
        return clientService.updateClient(id,clientDetails);
    }
    //delete client
    @DeleteMapping("/clients/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteClient(@PathVariable Long id){
        return clientService.deleteClient(id);
    }

}
