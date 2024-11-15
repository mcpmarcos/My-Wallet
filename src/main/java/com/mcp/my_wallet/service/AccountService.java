package com.mcp.my_wallet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mcp.my_wallet.DTO.AccountDTO;
import com.mcp.my_wallet.model.Account;
import com.mcp.my_wallet.repository.AccountRepository;
import java.util.ArrayList;

@Service
public class AccountService {
    
    @Autowired
    AccountRepository repository;
    
    public AccountDTO findById(Long id) {
        Account account = repository.findById(id).get();
        return createDTO(account);
    }

    public List<AccountDTO> findAllAccounts() {
        List<Account> accounts = repository.findAll();
        return createDTO(accounts);
    }

    public ResponseEntity<String> updateAccountBalance(AccountDTO updateAccount, Long id) {
        Account account = repository.findById(id).get();
        account.setAccountCreditLimit(updateAccount.accountCreditLimit());
        account.setConsumedCredit(updateAccount.consumedCredit());
        repository.save(account);
        return ResponseEntity.ok("Ok");
    }
   
    public AccountDTO createDTO(Account account){
        AccountDTO accountDTO = new AccountDTO(account.getId(), account.getClient(), account.getAccountCreditLimit(), account.getConsumedCredit());
        return accountDTO;
    }

    public List<AccountDTO> createDTO(List<Account> accounts){
        List<AccountDTO> accountsDTO = new ArrayList<>();
        for (Account account : accounts) {
            AccountDTO accountDTO = new AccountDTO(account.getId(), account.getClient(), account.getAccountCreditLimit(), account.getConsumedCredit());        
            accountsDTO.add(accountDTO);    
        }
        return accountsDTO;
    }



}
