package com.crisalis.backendcrisalis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crisalis.backendcrisalis.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Integer> {
    
}
