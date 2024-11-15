package com.mcp.my_wallet.DTO;

import com.mcp.my_wallet.model.Client;

public record AccountDTO(Long id, Client client, Long accountCreditLimit, Long consumedCredit) {
    
}
