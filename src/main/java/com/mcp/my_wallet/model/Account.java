package com.mcp.my_wallet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Account {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @JsonIgnore
    @OneToOne(mappedBy = "account")
    private Client client;

    private Long accountCreditLimit;

    // List of cards
    // List of transactions
    // List of invoices

    public Account(Long id, Client client, Long accountCreditLimit) {
        this.id = id;
        this.client = client;
        this.accountCreditLimit = accountCreditLimit;
    }

    public Account() {
        
    }
}