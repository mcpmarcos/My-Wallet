package com.mcp.my_wallet.repository;
import java.util.List;
import java.util.Optional;

import com.mcp.my_wallet.model.Client;
import com.mcp.my_wallet.model.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TransactionRepository extends JpaRepository<Transaction, Long>{
   
}
