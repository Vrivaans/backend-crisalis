package com.crisalis.backendcrisalis.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ibm.icu.math.BigDecimal;

@Entity
@Table(name = "order_detail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private float precioVenta;

    private int cantidad;

    private float soportePrecio;

    private int garantia;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, optional = true)
    @JoinColumn(name = "id_producto")
    private Productos productos;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, optional = true)
    @JoinColumn(name = "id_servicio")
    private Servicios servicios;

    public OrderDetail (){

    }

    public OrderDetail(int id, float precioVenta, int cantidad,float soportePrecio, Productos productos, Servicios servicios) {
        this.id = id;
        this.precioVenta = precioVenta;
        this.cantidad = cantidad;
        this.soportePrecio = soportePrecio;
        this.productos = productos;
        this.servicios = servicios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public Servicios getServicios() {
        return servicios;
    }

    public void setServicios(Servicios servicios) {
        this.servicios = servicios;
    }

    public float getSoportePrecio() {
        return soportePrecio;
    }

    public void setSoportePrecio(float soportePrecio) {
        this.soportePrecio = soportePrecio;
    }

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }   

   


    
}
