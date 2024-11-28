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

import com.mcp.my_wallet.DTO.CreditCardBrandDTO;
import com.mcp.my_wallet.model.CreditCard;
import com.mcp.my_wallet.service.CreditCardService;

@RestController
public class CreditCardController {
    
    @Autowired
    CreditCardService creditCardService;

    // create credit card 
    @PostMapping("/card/{clientId}")
    public ResponseEntity<CreditCard> createCreditCard(@RequestBody CreditCardBrandDTO brand, @PathVariable Long clientId){
        return creditCardService.createCreditCard(clientId, brand);
    }

     // find by id
    @GetMapping("/card/id/{id}")
    public CreditCard findCreditCardById(@PathVariable Long id){
        return creditCardService.findById(id);
    }
    
    //find by card numerber
    @GetMapping("/card/number/{cardNumber}")
    public CreditCard findCreditCardByCardNumber(@PathVariable String cardNumber){
        return creditCardService.findByCardNumber(cardNumber);
    }

    // find all cards >>> Add account id no parâmetro
    @GetMapping("/card")
    public List<CreditCard> findAllCreditCards(){
        return creditCardService.findAll();
    }

    // activate credit card
    @PutMapping("/card/activate/{cardNumber}")
    public ResponseEntity<String> activateCreditCard(@PathVariable String cardNumber) {
        return creditCardService.activateCreditCard(cardNumber);
    }

    // desactivate credit card
    @PutMapping("/card/deactivate/{cardNumber}")
    public ResponseEntity<String> desactivateCreditCard(@PathVariable String cardNumber) {
        return creditCardService.desactivateCreditCard(cardNumber);
    }

    // delete credit card
    @DeleteMapping("/card/{cardNumber}") 
    public void deleteCreditCard(@PathVariable String cardNumber) {
        creditCardService.deleteCreditCardBycardNumber(cardNumber);
    }
}
