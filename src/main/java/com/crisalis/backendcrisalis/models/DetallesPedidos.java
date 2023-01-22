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

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "detalles_pedidos")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DetallesPedidos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido", referencedColumnName = "id")
    private PedidosClientes pedidosClientes;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    private Productos producto;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_servicio", referencedColumnName = "id")
    private Servicios servicio;

    private int cantidad;

    private int garantia;
    
    private float precioDeVenta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PedidosClientes getPedidosClientes() {
        return pedidosClientes;
    }

    public void setPedidosClientes(PedidosClientes pedidosClientes) {
        this.pedidosClientes = pedidosClientes;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public Servicios getServicio() {
        return servicio;
    }

    public void setServicio(Servicios servicio) {
        this.servicio = servicio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }

    public float getPrecioDeVenta() {
        return precioDeVenta;
    }

    public void setPrecioDeVenta(float precioDeVenta) {
        this.precioDeVenta = precioDeVenta;
    }
    
    
    

}
