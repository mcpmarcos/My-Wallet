package com.mcp.my_wallet.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Transaction {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long amount;
    
    private String buyingLocation;
    
    private String operatorName;
    
    @CreationTimestamp
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime timestamp;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    // private transactionParcell parcell;
    // int qtdParcela

    /*
     * Parcell
     *  id
     *  valor
    */

    public Transaction(Long id, Long amount, String buyingLocation, String operatorName) {
        this.id = id;
        this.amount = amount;
        this.buyingLocation = buyingLocation;
        this.operatorName = operatorName;
    }

}
