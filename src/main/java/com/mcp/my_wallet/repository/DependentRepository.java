package com.mcp.my_wallet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mcp.my_wallet.model.Dependent;

@Repository
public interface DependentRepository extends JpaRepository<Dependent, Long> {
    
        //Optional<Dependent> findByCard(String cardNumber);

}
