package com.crisalis.backendcrisalis.repository;

import com.crisalis.backendcrisalis.models.ServiciosContratados;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ServiciosContratadosRepository extends JpaRepository<ServiciosContratados, Integer>{
    
    //Querys nativas para obtener una lista con los servicios contratados por una empresa y un cliente 
    
    @Query(value = "{call servicios_contratados_por_cliente(:id)}", nativeQuery = true)
    List<ServiciosContratados> ServiciosContratadosPorCliente(int id);

    @Query(value = "{call servicios_contratados_por_empresa(:id)}", nativeQuery = true)
    List<ServiciosContratados> ServiciosContratadosPorEmpresa(int id);

}
