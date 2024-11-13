package com.mcp.my_wallet.model;


import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int cpf;

    private String name;

    private String password;

    @CreationTimestamp
    private LocalDateTime birth; 

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    // private Account account;

    public Client (Long id, int cpf, String name, String password, LocalDateTime birth, Address address) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.password = password;
        this.birth = birth;
        this.address =  address;
    }

    public Client (){

    }

}
