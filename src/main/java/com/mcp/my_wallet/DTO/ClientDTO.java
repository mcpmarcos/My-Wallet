package com.mcp.my_wallet.DTO;

import java.time.LocalDateTime;

import com.mcp.my_wallet.model.Account;
import com.mcp.my_wallet.model.Address;

public record ClientDTO(Long id, int cpf, String name, String password, LocalDateTime birth, Address address, Account account) {
    
}
