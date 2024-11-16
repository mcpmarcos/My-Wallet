package com.mcp.my_wallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mcp.my_wallet.DTO.CreditCardBrandDTO;
import com.mcp.my_wallet.enums.CardBrand;
import com.mcp.my_wallet.model.CreditCard;
import com.mcp.my_wallet.repository.CreditCardRepository;
import java.util.List;

@Service
public class CreditCardService {

    @Autowired
    CreditCardRepository creditCardRepository;

    public ResponseEntity<CreditCard> createCreditCard(CreditCardBrandDTO creditCardDTO) {
        CreditCard newCreditCard = new CreditCard(creditCardDTO.cardBrand());
        
        newCreditCard.setActivated(false);
        newCreditCard.setCardNumber("3251654684");
        newCreditCard.setBinNumber("123456");
        
        //newCreditCard.setBinNumber(CreditCardUtils.generateBinNumber(newCreditCard.getCardBrand()));
        //CreditCardUtils.generateNumbers(newCreditCard);
        
        creditCardRepository.save(newCreditCard);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCreditCard);
    }
    
    public ResponseEntity<CreditCard> createCreditCard(CardBrand brand) {
        CreditCard newCreditCard = new CreditCard(brand);
        newCreditCard.setActivated(false);
        newCreditCard.setCardNumber("3251654684");
        newCreditCard.setBinNumber("123456");
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
    
    // CREATE DTOs
    /*
     public FullCreditCardDTO createDTO(CreditCard creditCard) {
        FullCreditCardDTO fullCreditCardDTO = new FullCreditCardDTO(
            creditCard.getId(),
            creditCard.getCardBrand(),
            creditCard.getCardNumber(),
            creditCard.getBinNumber(),
            creditCard.getIsActivated()
        );
        return fullCreditCardDTO;
    }
    */


}
