package com.mcp.my_wallet.DTO;

import com.mcp.my_wallet.enums.CardBrand;

public record FullCreditCardDTO(Long id, CardBrand cardBrand, Long cardNumber, Long binNumber, boolean isActivated) {

   

    
    
}
