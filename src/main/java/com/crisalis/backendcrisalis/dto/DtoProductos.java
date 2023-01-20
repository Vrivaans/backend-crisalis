package com.crisalis.backendcrisalis.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import com.crisalis.backendcrisalis.models.DetallesPedidos;
import com.crisalis.backendcrisalis.models.SuperClaseProductos;

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
public class DtoProductos extends SuperClaseProductos {

    private Set<DetallesPedidos>detallesPedidos = new HashSet<>();

}