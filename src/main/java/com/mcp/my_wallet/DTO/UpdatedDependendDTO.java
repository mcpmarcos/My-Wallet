package com.mcp.my_wallet.DTO;

import java.time.LocalDateTime;

public record UpdatedDependendDTO(Long id, int cpf, String clientName, LocalDateTime birth) {
    
}
