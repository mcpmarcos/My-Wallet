package com.mcp.my_wallet.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mcp.my_wallet.DTO.AccountDTO;
import com.mcp.my_wallet.DTO.ClientDTO;
import com.mcp.my_wallet.model.Account;
import com.mcp.my_wallet.model.Client;
import com.mcp.my_wallet.repository.AccountRepository;


public class AccountService {
    
    @Autowired
    AccountRepository repositeory;
    
    public AccountDTO findById(Long id) {
        Account account = repository.findById(id).get();
        return createDTO(account);
    }

    //findAllAccounts
    
    //updateCreditLimit(Long nreCreditLimit)
    
    // createDTO methods
}
