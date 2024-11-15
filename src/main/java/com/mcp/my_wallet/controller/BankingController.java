package com.mcp.my_wallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mcp.my_wallet.DTO.AccountDTO;
import com.mcp.my_wallet.service.AccountService;

@RestController
public class BankingController {
    
    @Autowired
    AccountService service;
    
    // update account credit limit / Credit limit
    @PutMapping("/account/{id}")
    public ResponseEntity<String> updateAccountBalance(@RequestBody AccountDTO updateAccount, @PathVariable Long id) {

        return service.updateAccountBalance(updateAccount, id);
    }

    // create credit card

    // paymentTransaction


    // 
}
