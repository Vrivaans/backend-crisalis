package com.crisalis.backendcrisalis.dto;



public class DtoOrderDetail {
    // nombre!: string
    // garantia!: number
    // cantidad!: number
    // precioVenta!: number
    // esServicio!: boolean
    // precioSoporte!: number

    private String nombre;

    private int garantia;

    private int cantidad;

    private float precioVenta;

    private boolean esServicio;

    private float soportePrecio;

    public DtoOrderDetail(String nombre, int garantia, int cantidad, float precioVenta, boolean esServicio,
            float soportePrecio) {
        this.nombre = nombre;
        this.garantia = garantia;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.esServicio = esServicio;
        this.soportePrecio = soportePrecio;
    }

    public DtoOrderDetail() {
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public boolean isEsServicio() {
        return esServicio;
    }

    public void setEsServicio(boolean esServicio) {
        this.esServicio = esServicio;
    }

    public float getSoportePrecio() {
        return soportePrecio;
    }

    public void setSoportePrecio(float soportePrecio) {
        this.soportePrecio = soportePrecio;
    }

    



    
}
