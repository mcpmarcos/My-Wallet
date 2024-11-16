package com.mcp.my_wallet.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mcp.my_wallet.DTO.CreditCardDTO;
import com.mcp.my_wallet.enums.CardBrand;
import com.mcp.my_wallet.model.CreditCard;
import com.mcp.my_wallet.repository.CreditCardRepository;
import java.util.List;

@Service
public class CreditCardService {

    CreditCardRepository creditCardRepository;

    public ResponseEntity<CreditCard> createCreditCard(CreditCardDTO creditCardDTO) {
        CreditCard newCreditCard = new CreditCard(creditCardDTO.cardBrand());
        
        newCreditCard.setActivated(false);
        newCreditCard.setCardNumber("3251654684");
        newCreditCard.setBinNumber("123456");
        
        //newCreditCard.setBinNumber(CreditCardUtils.generateBinNumber(newCreditCard.getCardBrand()));
        //CreditCardUtils.generateNumbers(newCreditCard);
        
        creditCardRepository.save(newCreditCard);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCreditCard);
    }

    
    //public ResponseEntity<CreditCard> createCreditCard(CardBrand brand) {
        //    return null;
    //}
    

    // find credit card by id(id)
    public CreditCard findById(Long id){
        CreditCard creditCard = creditCardRepository.findById(id).get();
        return createDTO(creditCard); 
    }
    
    // find credit card by card number 
    public CreditCard findByCardNumber(Long cardNumber){
        CreditCard creditCard = creditCardRepository.findByCardNumber(cardNumber).get();
        return createDTO(creditCard); 
    }
    
    // find all credit cards
    public List<CreditCard> findAll(){
        List<CreditCard> creditCards = creditCardRepository.findAll();
        return createDTO(creditCards);
    }

    // activate credit card()
    
    // desactivate credit card()
    
    // delete credit card(id)
    public void deleteCreditCard(Long id) {
        CreditCard creditCard = creditCardRepository.findById(id).get();
        creditCardRepository.delete(creditCard);
    }
    
    // create dtos

    


}
