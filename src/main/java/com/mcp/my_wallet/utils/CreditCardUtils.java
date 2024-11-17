package com.mcp.my_wallet.utils;

import org.springframework.stereotype.Service;

import com.mcp.my_wallet.enums.CardBrand;
import com.mcp.my_wallet.model.CreditCard;

@Service
public class CreditCardUtils {
    
    
    public String generateCardNumber(CreditCard card){
        return card.getBinNumber() + generateRandomNumber();
    }
        
    public String generateRandomNumber() {
        Long min = 0L;
        Long max = 999_999_999_999L;
        Long randomNumber = (long) (Math.random() * (max - min + 1));        
        String formattedNumber = String.format("%012d", randomNumber);
        return formattedNumber;
    }
    
    public String generateBinNumber(CardBrand brand) {
        String binDigits = "";
        switch (brand) {
            case VISA:
                binDigits = "5755"; // BIN para cartões Visa
                break;
            case MASTERCARD:
                binDigits = "7822"; // BIN para cartões Mastercard
                break;
            case MAESTRO:
                binDigits = "1441"; // BIN para American Express
                break;
            case UNION_PAY:
                binDigits = "9922"; // BIN para cartões Discover
                break;
            }
        return binDigits;
    }

    
}
