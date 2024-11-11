package com.mcp.my_wallet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Address {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String street;

    private int number;

    private String cep;

    private String city;

    private String state;

    public Address(Long id, String street, int number, String cep, String city, String state) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.cep = cep;
        this.city = city;
        this.state = state;
    }

    public Address() {
    
    }

}
