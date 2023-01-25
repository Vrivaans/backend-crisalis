package com.crisalis.backendcrisalis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crisalis.backendcrisalis.models.OrderDetail;

@Repository
public interface OrderDetailRepository extends JpaRepository <OrderDetail, Integer> {
    
}
