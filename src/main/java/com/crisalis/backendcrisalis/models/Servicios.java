package com.crisalis.backendcrisalis.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Servicios extends SuperClaseProductos {
    
    @Column(name = "soporte_precio")
    private float soportePrecio;

    @Column(name = "es_especial")
    private boolean esEspecial;

    @OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL)
    private List<ServiciosContratados> serviciosContratados;

    public Servicios(int id, float precioBase, String nombre, float soportePrecio, boolean esEspecial) {
        super(id, precioBase, nombre);
        this.soportePrecio = soportePrecio;
        this.esEspecial = esEspecial;
    }

    public Servicios(float soportePrecio, boolean esEspecial) {
        this.soportePrecio = soportePrecio;
        this.esEspecial = esEspecial;
    }

    public Servicios(){}

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

 
    


}
