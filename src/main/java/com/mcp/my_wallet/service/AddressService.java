package com.mcp.my_wallet.service;

import java.util.ArrayList;
import java.util.List;

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
    
    public List<AddressDTO> findAllAddresses() {
        List<Address> addresses = repository.findAll();
        return createDTO(addresses);
    }

    public ResponseEntity<String> updateAddress(AddressDTO addressDTO, Long id) {
        Address newAddress = repository.findById(id).get();
        if (!newAddress.equals(null)) {
            newAddress.setStreet(addressDTO.street());
            newAddress.setNumber(addressDTO.number());
            newAddress.setCep(addressDTO.cep());
            newAddress.setCity(addressDTO.city());
            newAddress.setState(addressDTO.state());
            repository.save(newAddress);
        }
        return ResponseEntity.ok("Ok");
        }

    public void deleteAddress(Long id) {
        Address address = repository.findById(id).get();
        repository.delete(address);
    }

    public AddressDTO createDTO(Address address){
        AddressDTO addressDTO = new AddressDTO(address.getId(), address.getStreet(), address.getNumber(), address.getCep(), address.getCity(), address.getState());
        return addressDTO;
    }

    public List<AddressDTO> createDTO(List<Address> addresses){
        List<AddressDTO> addressDTOs = new ArrayList<>();
        for (Address address: addresses) {        
            AddressDTO addressDTO = new AddressDTO(address.getId(), address.getStreet(), address.getNumber(), address.getCep(), address.getCity(), address.getState());
            addressDTOs.add(addressDTO);
        }
        return addressDTOs;
    }

}
