package com.crisalis.backendcrisalis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crisalis.backendcrisalis.models.Productos;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer> {
    
}
