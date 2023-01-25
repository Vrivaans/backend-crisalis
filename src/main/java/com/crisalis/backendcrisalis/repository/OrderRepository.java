package com.crisalis.backendcrisalis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crisalis.backendcrisalis.models.OrderE;

@Repository
public interface OrderRepository extends JpaRepository<OrderE, Integer> {
    
}
