package com.crisalis.backendcrisalis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crisalis.backendcrisalis.models.Servicios;

@Repository
public interface ServiciosRepository extends JpaRepository<Servicios, Integer> {
    
}
