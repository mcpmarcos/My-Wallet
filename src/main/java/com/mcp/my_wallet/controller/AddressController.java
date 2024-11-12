package com.mcp.my_wallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.mcp.my_wallet.service.AddresService;

@RestController
public class AddressController {
    
    @Autowired
    private AddresService service;

}
