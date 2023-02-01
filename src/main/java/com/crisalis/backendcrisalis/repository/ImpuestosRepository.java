package com.crisalis.backendcrisalis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crisalis.backendcrisalis.models.Impuestos;

@Repository
public interface ImpuestosRepository extends JpaRepository<Impuestos, Integer> {

    //public Optional<Impuestos> findImpuestoByNombre(String nombreImpuesto);
}
