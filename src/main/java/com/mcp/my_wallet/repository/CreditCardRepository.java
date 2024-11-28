package com.mcp.my_wallet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mcp.my_wallet.model.CreditCard;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long>{

    Optional<CreditCard> findByCardNumber(String cardNumber);
    
    
}
