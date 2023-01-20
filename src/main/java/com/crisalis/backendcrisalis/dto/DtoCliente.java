package com.crisalis.backendcrisalis.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.crisalis.backendcrisalis.models.Empresa;
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
public class DtoCliente extends Persona {


    private Set<PedidosClientes> pedidos = new HashSet<>();

    private Set<ServiciosContratados> serviciosContratados = new HashSet<>();

}
