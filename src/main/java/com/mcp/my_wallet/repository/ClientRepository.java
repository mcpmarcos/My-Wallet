package com.mcp.my_wallet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcp.my_wallet.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
 
    Optional<Client> findById(Long id);
}
