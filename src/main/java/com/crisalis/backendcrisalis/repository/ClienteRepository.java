package com.crisalis.backendcrisalis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crisalis.backendcrisalis.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Integer> {
    public boolean existsByDniCliente(String dniCliente);
    //Para tratar de buscar cliente por dni
    public Optional<Cliente> findByDniCliente(String dniCliente);
}
