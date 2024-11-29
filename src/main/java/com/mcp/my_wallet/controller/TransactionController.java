package com.mcp.my_wallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mcp.my_wallet.DTO.TransactionDTO;
import com.mcp.my_wallet.model.Transaction;
import com.mcp.my_wallet.service.TransactionService;

@RestController
public class TransactionController {
    
    @Autowired
    private TransactionService transactionService;
    
    // public perform Transaction
    @PostMapping("/transaction/{cardNumber}")    
    public ResponseEntity<Transaction> paymentTransaction(@RequestBody TransactionDTO transaction, String cardNumber){
        return  transactionService.paymentTransaction(transaction, cardNumber);
    }

    // find all transactions
    @GetMapping("/transaction")
    public List<TransactionDTO> findAllTransactions() {
       return transactionService.findAllTransactions();
    }
}
