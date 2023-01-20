package com.crisalis.backendcrisalis.dto;

import com.crisalis.backendcrisalis.models.PedidosClientes;
import com.crisalis.backendcrisalis.models.Productos;
import com.crisalis.backendcrisalis.models.Servicios;

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
public class DtoDetallesPedido {
    

    private int id;
    private PedidosClientes pedidosClientes;
    private Productos producto;
    private Servicios servicio;
    private int cantidad;
    private int garantia;
    private float precioDeVenta;

}
