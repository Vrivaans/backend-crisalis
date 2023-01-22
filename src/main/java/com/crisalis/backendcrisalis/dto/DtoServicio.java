package com.crisalis.backendcrisalis.dto;

import java.util.ArrayList;
import java.util.List;

import com.crisalis.backendcrisalis.models.DetallesPedidos;
import com.crisalis.backendcrisalis.models.ServiciosContratados;
import com.crisalis.backendcrisalis.models.SuperClaseProductos;

import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@NoArgsConstructor
public class DtoServicio extends SuperClaseProductos {
    


    private float soportePrecio;
    private boolean esEspecial;

    private List<ServiciosContratados> serviciosContratados;
    private List<DetallesPedidos>detallesPedidos = new ArrayList<>();

    
    


    public float getSoportePrecio() {
        return soportePrecio;
    }
    public void setSoportePrecio(float soportePrecio) {
        this.soportePrecio = soportePrecio;
    }
    public boolean isEsEspecial() {
        return esEspecial;
    }
    public void setEsEspecial(boolean esEspecial) {
        this.esEspecial = esEspecial;
    }
    public List<ServiciosContratados> getServiciosContratados() {
        return serviciosContratados;
    }
    public void setServiciosContratados(List<ServiciosContratados> serviciosContratados) {
        this.serviciosContratados = serviciosContratados;
    }
    public List<DetallesPedidos> getDetallesPedidos() {
        return detallesPedidos;
    }
    public void setDetallesPedidos(List<DetallesPedidos> detallesPedidos) {
        this.detallesPedidos = detallesPedidos;
    }
}
