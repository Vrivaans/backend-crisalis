package com.crisalis.backendcrisalis.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crisalis.backendcrisalis.Models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Integer> {
    
}
