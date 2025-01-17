package com.mcp.my_wallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.mcp.my_wallet.DTO.AddressDTO;
import com.mcp.my_wallet.model.Address;
import com.mcp.my_wallet.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AddressController {
    
    @Autowired
    private AddressService service;

    @PostMapping("/address")
    public ResponseEntity<Address> createAddress(@RequestBody AddressDTO addressDTO) {
        return service.createAddress(addressDTO);
    }
    
   @GetMapping("/address/{id}")
   public AddressDTO findById(@PathVariable Long id){
       return service.findById(id); 
   }

   @GetMapping("/address")
   public List<AddressDTO> findAllAddresses() {
       return service.findAllAddresses();
   }

   @PutMapping("/address/{id}")
   public ResponseEntity<String> updateAddress(@RequestBody AddressDTO addressDTO, @PathVariable Long id) {
        return service.updateAddress(addressDTO, id);
    }

    @DeleteMapping("/address/{id}")
    public void deleteAddress(@PathVariable Long id) {
        service.deleteAddress(id);
    }
}
