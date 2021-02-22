package com.example.Givemeacar.service;

import com.example.Givemeacar.exception.ResourceNotFoundException;
import com.example.Givemeacar.model.Contract;
import com.example.Givemeacar.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {

    @Autowired // find what need to be injected
    //myInterface myBean
    private ContractRepository contractRepository;

    //get all contracts
    public List<Contract> getALLContract(){
        return contractRepository.findAll();
    }
    //create contract
    public Contract createContract(Contract contract) {
        return contractRepository.save(contract);
    }
    // get contract by id
    public ResponseEntity<Contract> getContractById(Long id) {
        Contract contract = contractRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contract not exist with id : " + id));

        return ResponseEntity.ok(contract);
    }
    //update contract
    public ResponseEntity<Contract> updateContract(Long id, Contract contractDetails){
        Contract contract = contractRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contract not exist with id : " + id));

        contract.setDate(contractDetails.getDate());

        Contract updatedContract = contractRepository.save(contract);
        return ResponseEntity.ok(updatedContract);
    }
}
