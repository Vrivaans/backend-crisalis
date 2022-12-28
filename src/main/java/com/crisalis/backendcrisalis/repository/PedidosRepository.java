package com.crisalis.backendcrisalis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crisalis.backendcrisalis.models.PedidosClientes;



@Repository
public interface PedidosRepository extends JpaRepository<PedidosClientes, Integer> {
    
}
