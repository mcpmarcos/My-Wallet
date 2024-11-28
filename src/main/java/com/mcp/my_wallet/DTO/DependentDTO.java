package com.mcp.my_wallet.DTO;

import java.time.LocalDateTime;

import com.mcp.my_wallet.model.CreditCard;

public record DependentDTO(Long id, String dependentCpf, String clientName, LocalDateTime birth, CreditCard card) {
    
}
