package com.crisalis.backendcrisalis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crisalis.backendcrisalis.models.OrderE;

@Repository
public interface OrderRepository extends JpaRepository<OrderE, Integer> {
    
    @Query(value = "{call pedidos_cliente(:id)}", nativeQuery = true)
    List<OrderE> pedidosCliente(int id);

    @Query(value = "{call pedidos_empresa(:id)}", nativeQuery = true)
    List<OrderE> pedidosEmpresa(int id);


}
