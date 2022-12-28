package com.crisalis.backendcrisalis.models;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

@Entity
public class Productos extends SuperClaseProductos {
    
    private int garantia;

    public Productos(int id, float precioBase, String nombre, int garantia) {
        super(id, precioBase, nombre);
        this.garantia = garantia;
    }

    public Productos(int garantia) {
        this.garantia = garantia;
    }
    public Productos(){}

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }
}
