package com.crisalis.backendcrisalis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crisalis.backendcrisalis.models.Productos;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer> {
    //public boolean existsByDniCliente(String dniCliente);
    //Para tratar de buscar cliente por dni
    public Optional<Productos> findProductoByNombre(String nombre);

}
