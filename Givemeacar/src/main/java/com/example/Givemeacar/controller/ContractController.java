package com.example.Givemeacar.controller;

import com.example.Givemeacar.model.Contract;
import com.example.Givemeacar.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ContractController {

    @Autowired // find what need to be injected
    //myInterface myBean
    private ContractRepository contractRepository;

    //get all contracts
    @GetMapping("/contracts")
    public List<Contract> getALLContract(){
        return contractRepository.findAll();
    }

    //create contract
    @PostMapping("/contracts")
    public Contract createContract(@RequestBody Contract contract) {
        return contractRepository.save(contract);
    }

}