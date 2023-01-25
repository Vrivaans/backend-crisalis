package com.crisalis.backendcrisalis.dto;

import java.util.ArrayList;
import java.util.List;

import com.crisalis.backendcrisalis.models.Cliente;
import com.crisalis.backendcrisalis.models.Empresa;
import com.crisalis.backendcrisalis.models.OrderDetail;

import lombok.ToString;

@ToString
public class DtoOrder {
    

    private int id; 

    private String fechaPedido;

    private int totalPedido;

    private String codigoIdentificador;

    private boolean activo;
    
    private Cliente cliente;

    private Empresa empresa;



    List<OrderDetail> orderDetails = new ArrayList<>();


}
