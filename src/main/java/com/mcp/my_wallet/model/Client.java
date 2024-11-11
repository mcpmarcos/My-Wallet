package com.mcp.my_wallet.model;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int cpf;

    private String name;

    private LocalDateTime date; 

    public Client (Long id, int cpf, String name, LocalDateTime date) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.date = date;
    }

    public Client (){

    }

}
