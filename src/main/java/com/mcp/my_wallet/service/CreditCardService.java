package com.mcp.my_wallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mcp.my_wallet.DTO.ClientDTO;
import com.mcp.my_wallet.DTO.CreditCardBrandDTO;
import com.mcp.my_wallet.enums.CardBrand;
import com.mcp.my_wallet.model.Account;
import com.mcp.my_wallet.model.CreditCard;
import com.mcp.my_wallet.repository.CreditCardRepository;
import com.mcp.my_wallet.utils.CreditCardUtils;

import java.util.List;

@Service
public class CreditCardService {

    @Autowired
    CreditCardRepository creditCardRepository;
    
    @Autowired
    ClientService clientService;

    @Autowired
    CreditCardUtils creditCardUtils;
    
    //Create credit cards
    public ResponseEntity<CreditCard> createCreditCard(Long clientId, CreditCardBrandDTO brand) {

        ClientDTO clientDTO = clientService.findById(clientId);
        Account account = clientDTO.account();
        CardBrand cardBrand = brand.cardBrand();
        CreditCard newCreditCard = new CreditCard(cardBrand);
        newCreditCard.setActivated(false);
        newCreditCard.setBinNumber(creditCardUtils.generateBinNumber(cardBrand));
        String cardNumber = creditCardUtils.generateCardNumber(newCreditCard);
         if(creditCardRepository.findByCardNumber(cardNumber) != null) {
            cardNumber = creditCardUtils.generateCardNumber(newCreditCard);
         }
        newCreditCard.setCardNumber(cardNumber);
        newCreditCard.setAccount(account);
        account.getCards().add(newCreditCard);
        creditCardRepository.save(newCreditCard);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCreditCard);
    } 
        
    // find credit card by id(id)
    public CreditCard findById(Long id){
        CreditCard creditCard = creditCardRepository.findById(id).get();
        return creditCard; 
    }
    
    // find credit card by card number 
    public CreditCard findByCardNumber(String cardNumber){
        CreditCard creditCard = creditCardRepository.findByCardNumber(cardNumber).get();
        return creditCard; 
    }
      
    // find all credit cards
    public List<CreditCard> findAll(){
        List<CreditCard> creditCards = creditCardRepository.findAll();
        return creditCards;
    }

    // activate credit card
    public ResponseEntity<String> activateCreditCard(Long id) {
        CreditCard creditCard = creditCardRepository.findById(id).get();
        creditCard.setActivated(true);
        creditCardRepository.save(creditCard);
        return ResponseEntity.ok("Ok");
    }
    
    // desactivate credit card
    public ResponseEntity<String> desactivateCreditCard(Long id) {
        CreditCard creditCard = creditCardRepository.findById(id).get();
        creditCard.setActivated(false);
        creditCardRepository.save(creditCard);
        return ResponseEntity.ok("Ok");
    }
    
    // delete credit card
    public void deleteCreditCard(Long id) {
        CreditCard creditCard = creditCardRepository.findById(id).get();
        creditCardRepository.delete(creditCard);
    }

}
