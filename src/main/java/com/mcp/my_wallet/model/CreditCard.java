package com.mcp.my_wallet.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mcp.my_wallet.enums.*;
import com.mcp.my_wallet.enums.CardBrand;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    
    @JsonIgnore 
    @ManyToOne
    @JoinColumn(name = "acocunt_id", referencedColumnName = "id") 
    private Account account; 
    
  
    @OneToMany(mappedBy = "card") 
    private List<Dependent> dependents;
    
    public CreditCard(Long id, CardBrand cardBrand, String cardNumber, String binNumber, boolean isActivated) {
        this.id = id;
        this.cardBrand = cardBrand;
        this.cardNumber = cardNumber;
        this.binNumber = binNumber;
        this.isActivated = isActivated;
    }

    public CreditCard(CardBrand cardBrand) {
        this.cardBrand = cardBrand;
    }

    public CreditCard(){}

    public boolean getIsActivated() {
        return isActivated;
    }
}
