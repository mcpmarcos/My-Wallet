package com.mcp.my_wallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcp.my_wallet.repository.AddressRepository;

@Service
public class AddresService {
    
    @Autowired
    private AddressRepository repository;


}
