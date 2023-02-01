package com.crisalis.backendcrisalis.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.GenerationType;

@MappedSuperclass
public class SuperClaseProductos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "precio_base")
    private float precioBase;

    @Column(unique = true)
    private String nombre;
    private boolean aplicaIva;
    private boolean aplicaIBrutos;
    private boolean aplicaGanancias;

    public SuperClaseProductos(int id, float precioBase, String nombre, boolean aplicaIva, boolean aplicaIBrutos, boolean aplicaGanancias) {
        this.id = id;
        this.precioBase = precioBase;
        this.nombre = nombre;
        this.aplicaIva = aplicaIva;
        this.aplicaIBrutos = aplicaIBrutos;
        this.aplicaGanancias = aplicaGanancias;
    }

    public SuperClaseProductos (){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(float precioBase) {
        this.precioBase = precioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isAplicaIva() {
        return aplicaIva;
    }

    public void setAplicaIva(boolean aplicaIva) {
        this.aplicaIva = aplicaIva;
    }

    public boolean isAplicaIBrutos() {
        return aplicaIBrutos;
    }

    public void setAplicaIBrutos(boolean aplicaIBrutos) {
        this.aplicaIBrutos = aplicaIBrutos;
    }

    public boolean isAplicaGanancias() {
        return aplicaGanancias;
    }

    public void setAplicaGanancias(boolean aplicaGanancias) {
        this.aplicaGanancias = aplicaGanancias;
    }

}
