package com.crisalis.backendcrisalis.dto;

import javax.validation.constraints.NotBlank;

//import com.crisalis.backendcrisalis.models.SuperClaseProductos;

public class DtoProductos {

    @NotBlank
    private float precioBase;

    @NotBlank
    private String nombre;

    @NotBlank
    private int garantia;

    public DtoProductos(@NotBlank float precioBase, @NotBlank String nombre, @NotBlank int garantia) {
        this.precioBase = precioBase;
        this.nombre = nombre;
        this.garantia = garantia;
    }

    public DtoProductos() {
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

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }

    

}
