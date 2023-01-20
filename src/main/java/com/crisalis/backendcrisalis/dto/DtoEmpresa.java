package com.crisalis.backendcrisalis.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;

import com.crisalis.backendcrisalis.models.PedidosClientes;
import com.crisalis.backendcrisalis.models.Persona;
import com.crisalis.backendcrisalis.models.ServiciosContratados;

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
public class DtoEmpresa extends Persona {

    private String cuit;

    private String razonSocial;

    private String fechaInicioActividades;

    private Set<PedidosClientes> pedidos = new HashSet<>();

    private Set<ServiciosContratados> serviciosContratados = new HashSet<>();
    
}
