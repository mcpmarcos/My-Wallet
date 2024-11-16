package com.mcp.my_wallet.DTO;

import java.util.List;

import com.mcp.my_wallet.model.Client;
import com.mcp.my_wallet.model.CreditCard;

public record AccountDTO(Long id, Client client, Long accountCreditLimit, Long consumedCredit, List<CreditCard> cards) {
    
}
