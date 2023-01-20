package com.crisalis.backendcrisalis.dto;

import java.util.ArrayList;
import java.util.List;

import com.crisalis.backendcrisalis.models.DetallesPedidos;
import com.crisalis.backendcrisalis.models.ServiciosContratados;
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
public class DtoServicio extends SuperClaseProductos {
    


    private float soportePrecio;
    private boolean esEspecial;

    private List<ServiciosContratados> serviciosContratados;
    private List<DetallesPedidos>detallesPedidos = new ArrayList<>();
}
