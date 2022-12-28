package com.crisalis.backendcrisalis.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Servicios extends SuperClaseProductos {
    
    @Column(name = "soporte_precio")
    private float soportePrecio;

    @Column(name = "es_especial")
    private boolean esEspecial;

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
