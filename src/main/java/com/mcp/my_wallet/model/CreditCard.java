package com.mcp.my_wallet.model;

import com.mcp.my_wallet.enums.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;;

@Entity
@Data
public class CreditCard {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardNumber;

    private String binNumber;

    private CardBrand cardBrand;
    
    private boolean isActivated;
    
    // List of dependents
    
    // JsonIgnore ManyToOne (mappedBy = cards) account 

    public CreditCard(CardBrand cardBrand) {
        this.cardBrand = cardBrand;
    }

    public CreditCard(){}

    
}
