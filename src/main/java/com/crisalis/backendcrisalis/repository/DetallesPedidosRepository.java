package com.crisalis.backendcrisalis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crisalis.backendcrisalis.models.DetallesPedidos;

@Repository
public interface DetallesPedidosRepository extends JpaRepository<DetallesPedidos, Integer>{
    
}
