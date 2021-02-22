package com.example.Givemeacar.controller;

import com.example.Givemeacar.model.Contract;
import com.example.Givemeacar.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class ContractController {

    @Autowired // find what need to be injected
    //myInterface myBean
    private ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    //get all contracts
    @GetMapping("/contracts")
    public List<Contract> getALLContract(){
        return contractService.getALLContract();
    }

    //create contract
    @PostMapping("/contracts")
    public void createContract(@RequestBody Contract contract) {

        contractService.createContract(contract);
    }

    // get contract by id
    @GetMapping("/contracts/{id}")
    public ResponseEntity<Contract> getCoById(@PathVariable Long id) {

        return contractService.getContractById(id);
    }
    //update contract
    @PutMapping("/contracts/{id}")
    public ResponseEntity<Contract> updateContract(@PathVariable Long id, @RequestBody Contract contractDetails){

        return contractService.updateContract(id, contractDetails);
    }

}