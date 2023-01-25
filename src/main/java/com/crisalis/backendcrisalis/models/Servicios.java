package com.crisalis.backendcrisalis.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString
public class Servicios extends SuperClaseProductos {
    
    @Column(name = "soporte_precio")
    @NotNull
    private int soportePrecio;

    public Servicios(){

    }

    public Servicios(int id, float precioBase, String nombre, boolean aplicaIva, boolean aplicaIBrutos,
            boolean aplicaGanancias, int soportePrecio) {
        super(id, precioBase, nombre, aplicaIva, aplicaIBrutos, aplicaGanancias);
        this.soportePrecio = soportePrecio;
    }

    public float getSoportePrecio() {
        return soportePrecio;
    }

    public void setSoportePrecio(int soportePrecio) {
        this.soportePrecio = soportePrecio;
    }

 


}
