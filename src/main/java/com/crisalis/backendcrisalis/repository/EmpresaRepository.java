package com.crisalis.backendcrisalis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crisalis.backendcrisalis.models.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository <Empresa, Integer> {
    
}
