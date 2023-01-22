package com.crisalis.backendcrisalis.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Servicios extends SuperClaseProductos {
    
    @Column(name = "soporte_precio")
    private float soportePrecio;

    @Column(name = "es_especial")
    private boolean esEspecial;

    

    

    @OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL)
    private List<ServiciosContratados> serviciosContratados;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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
