package com.mcp.my_wallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mcp.my_wallet.DTO.DependentDTO;
import com.mcp.my_wallet.service.DependentService;

@RestController
public class DependentController {
    
    @Autowired
    DependentService dependentService;

    @PostMapping("/dependent/{cardNumber}")
    public ResponseEntity<DependentDTO> insertDependentOnCard(@RequestBody DependentDTO dependentDTO, @PathVariable String cardNumber){
        return dependentService.insertDependentOnCard(dependentDTO, cardNumber);       
    }

    //find dependent by id
    @GetMapping("/dependent/id/{dependentId}")   
    public DependentDTO findDependedById(@PathVariable Long dependentId){
        return dependentService.findById(dependentId);
    }

    //find by cpf
    @GetMapping("/dependent/cpf/{dependentCpf}")   
    public DependentDTO findDependedByCpf(@PathVariable String dependentCpf){
        return dependentService.findByDependentCpf(dependentCpf);
    }


    //find all dependents
    @GetMapping("/dependent")
    public List<DependentDTO> findAllDependents(){
        return dependentService.findAll();
    }

    // update dependent data >>> algum defeito
    @PutMapping("/dependent/update/{dependentCpf}")
    public ResponseEntity<String> updateDependentData(@RequestBody DependentDTO dependentDTO, @PathVariable String dependentCpf){
        return dependentService.updateDependentData(dependentDTO, dependentCpf);
    }

    // delete dependent 
    @DeleteMapping("/dependent/{dependentId}")
    public void deleteDependent(@PathVariable Long dependentId){
        dependentService.deleteDependent(dependentId);
    }


}
