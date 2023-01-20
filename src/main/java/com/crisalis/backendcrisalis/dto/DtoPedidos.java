package com.crisalis.backendcrisalis.dto;

import java.util.HashSet;
import java.util.Set;

import com.crisalis.backendcrisalis.models.Cliente;
import com.crisalis.backendcrisalis.models.DetallesPedidos;
import com.crisalis.backendcrisalis.models.Empresa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DtoPedidos {
    
    
    private int id;
    private String fechaPedido;
    private Cliente cliente;
    private Empresa empresa;
    private Set<DetallesPedidos> detallesPedidos = new HashSet<>();
    

}
