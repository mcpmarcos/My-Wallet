package com.mcp.my_wallet.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Dependent {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String dependentCpf;
    
    private String clientName;
    
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime birth;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    private CreditCard card;
    

    public Dependent(Long id, String dependentCpf, String clientName, LocalDateTime birth, CreditCard card){
        this.id = id;
        this.dependentCpf = dependentCpf;
        this.clientName = clientName;
        this.birth = birth;
        this.card = card;
    }

    public Dependent(){}
}
