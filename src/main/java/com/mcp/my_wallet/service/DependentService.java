package com.mcp.my_wallet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.mcp.my_wallet.DTO.DependentDTO;
import com.mcp.my_wallet.DTO.UpdatedDependendDTO;
import com.mcp.my_wallet.model.CreditCard;
import com.mcp.my_wallet.model.Dependent;
import com.mcp.my_wallet.repository.DependentRepository;

@Service
public class DependentService {

    @Autowired
    DependentRepository dependentRepository;

    @Autowired
    CreditCardService cardService;

    public ResponseEntity<DependentDTO> insertDependentOnCard(DependentDTO dependentDTO, String cardNumber) {
        CreditCard card = cardService.findByCardNumber(cardNumber);
        Dependent dependent = new Dependent(dependentDTO.id(), dependentDTO.dependentCpf(), dependentDTO.clientName(), dependentDTO.birth(), card);
        card.getDependents().add(dependent);
        dependentRepository.save(dependent);
        return ResponseEntity.status(HttpStatus.CREATED).body(createDTO(dependent));
    }
    
    // find by id
    public DependentDTO findById(Long dependentId) {
        Dependent dependent = dependentRepository.findById(dependentId).get();
        return createDTO(dependent);
    }

    //find by cpf
    public DependentDTO findByDependentCpf(@PathVariable String dependentCpf){
        Dependent dependent = dependentRepository.findByDependentCpf(dependentCpf).get();
        return createDTO(dependent);
    }

    // find all
    public List<DependentDTO> findAll() {
        List<Dependent> dependents = dependentRepository.findAll();
        return createDTO(dependents);
    }
    
    // update dependent data
    public ResponseEntity<String> updateDependentData(DependentDTO dependentDTO, String cpf){
        Dependent dependent = dependentRepository.findByDependentCpf(cpf).get();
        if (!dependent.equals(null)) {
            dependent.setDependentCpf(dependentDTO.dependentCpf());
            dependent.setClientName(dependentDTO.clientName());
            dependent.setBirth(dependentDTO.birth());
            dependentRepository.save(dependent);
        }
        return ResponseEntity.ok("Ok");
    }

    // delete dependent
    public void deleteDependent(Long id) {
        Dependent dependent = dependentRepository.findById(id).get();
        dependentRepository.delete(dependent);
    }

    public DependentDTO createDTO(Dependent dependent) {
        DependentDTO dependentDTO = new DependentDTO(dependent.getId(), dependent.getDependentCpf(), dependent.getClientName(), dependent.getBirth(), dependent.getCard());
        return dependentDTO;
    }

    public List<DependentDTO> createDTO(List<Dependent> dependents) {
        List<DependentDTO> dependentsDTO = new ArrayList<>();
        for (Dependent dependent : dependents) {
            DependentDTO dependentDTO = new DependentDTO(dependent.getId(), dependent.getDependentCpf(), dependent.getClientName(), dependent.getBirth(), dependent.getCard());
            dependentsDTO.add(dependentDTO);
        }
        return dependentsDTO;
    }
}
