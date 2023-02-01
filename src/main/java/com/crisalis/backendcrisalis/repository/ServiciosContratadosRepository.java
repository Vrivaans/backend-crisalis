package com.crisalis.backendcrisalis.repository;

import com.crisalis.backendcrisalis.models.ServiciosContratados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ServiciosContratadosRepository extends JpaRepository<ServiciosContratados, Integer>{
    
    //@Query
    //Y acá no sé como hacer
}
