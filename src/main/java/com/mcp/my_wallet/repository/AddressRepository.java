package com.mcp.my_wallet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.mcp.my_wallet.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

  Optional<Address> findById(Long id);
} 
