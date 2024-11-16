package com.mcp.my_wallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mcp.my_wallet.DTO.AccountDTO;
import com.mcp.my_wallet.DTO.ClientDTO;
import com.mcp.my_wallet.DTO.CreditCardBrandDTO;
import com.mcp.my_wallet.model.Client;
import com.mcp.my_wallet.model.CreditCard;
import com.mcp.my_wallet.service.AccountService;
import com.mcp.my_wallet.service.ClientService;
import com.mcp.my_wallet.service.CreditCardService;

@RestController
public class BankingController {
    
    @Autowired
    ClientService clientService;

    @Autowired
    AccountService accountService;
    
    @Autowired
    CreditCardService creditCardService;
    
    
    
    // register client
    @PostMapping("/client")
    public ResponseEntity<Client>createclient(@RequestBody ClientDTO clientDTO) {
        return clientService.createClient(clientDTO);
    }

    // update account credit limit / consumed credit 
    @PutMapping("/account/{id}")
    public ResponseEntity<String> updateAccountBalance(@RequestBody AccountDTO updateAccount, @PathVariable Long accountId) {

        return accountService.updateAccountBalance(updateAccount, accountId);
    }

    // create credit card
    @PostMapping("/card")
    public ResponseEntity<CreditCard> createCreditCard(@RequestBody CreditCardBrandDTO creditCardDTO){
        return creditCardService.createCreditCard(creditCardDTO);
    }

    // delete credit card
    @DeleteMapping("/card/{id}")
    public void deleteCreditCard(@PathVariable Long id) {
        creditCardService.deleteCreditCard(id);
    }

    // activate credit card
    @PutMapping("/cardActivate/{id}")
    public ResponseEntity<String> activateCreditCard(@PathVariable Long id) {
        return creditCardService.activateCreditCard(id);
    }
    
    // desactivate credit card
    @PutMapping("/cardDesactivate/{id}")
    public ResponseEntity<String> desactivateCreditCard(@PathVariable Long id) {
        return creditCardService.desactivateCreditCard(id);
    }

    // find by id
    @GetMapping("/card/{id}")
    public CreditCard findCreditCardById(@PathVariable Long id){
        return creditCardService.findById(id);
    }
    
    //find by card numerber
    @GetMapping("/cardNumber/{cardNumber}")
    public CreditCard findCreditCardByCardNumber(@PathVariable String cardNumber){
        return creditCardService.findByCardNumber(cardNumber);
    }

    // find all cards
    @GetMapping("/card")
    public List<CreditCard> findAllCreditCards(){
        return creditCardService.findAll();
    }
    
    // Add dependents to credit card

    
    //==========================================

    // paymentTransaction   >>  update balance

    // save transaction in account

    // Generate invoice

    // quit invoice

    // save invoice in account

    // show dashboard

    
}
