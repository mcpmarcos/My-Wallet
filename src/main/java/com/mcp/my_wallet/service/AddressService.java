package com.mcp.my_wallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mcp.my_wallet.DTO.AddressDTO;
import com.mcp.my_wallet.model.Address;
import com.mcp.my_wallet.repository.AddressRepository;

@Service
public class AddressService {
    
    @Autowired
    private AddressRepository repository;

    public ResponseEntity<Address> createAddress(AddressDTO addressDTO) {
        Address newAddress = new Address(addressDTO.id(), addressDTO.street(), addressDTO.number(), addressDTO.cep(), addressDTO.city(), addressDTO.state());
        repository.save(newAddress);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAddress);
    }

    public AddressDTO findById(Long id) {
       Address address = repository.findById(id).get();
       return createDTO(address);
   }

    public AddressDTO createDTO(Address address){
        AddressDTO addressDTO = new AddressDTO(address.getId(), address.getStreet(), address.getNumber(), address.getCep(), address.getCity(), address.getState());
        return addressDTO;
    }


}
