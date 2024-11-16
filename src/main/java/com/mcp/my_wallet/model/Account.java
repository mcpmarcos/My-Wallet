package com.mcp.my_wallet.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
    
    private Long consumedCredit;
    
    // OneToMany 
    //@OneToMany
    //@JoinColumn(name = "id")
    //private List<CreditCard> cards;
    // OneToMany List of transactions
    // OneToMany List of invoices

    public Account(Long id, Client client, Long accountCreditLimit, Long consumedCredit) {
        this.id = id;
        this.client = client;
        this.accountCreditLimit = accountCreditLimit;
        this.consumedCredit = consumedCredit;
    }

    public Account() {
        
    }
}
