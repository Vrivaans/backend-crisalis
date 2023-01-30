package com.crisalis.backendcrisalis.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class OrderE {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private int id; 


    private String fechaPedido;

    private int totalPedido;

    // @Column(unique = true, nullable = false)
    // private String codigoIdentificador;

    private boolean activo;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "id_cliente")    
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "id_empresa")    
    private Empresa empresa;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    List<OrderDetail> orderDetails = new ArrayList<>();

    public OrderE(){

    }


    public OrderE(int id, String fechaPedido, int totalPedido, Cliente cliente, List<OrderDetail> orderDetails) {
        this.id = id;
        this.fechaPedido = fechaPedido;
        this.totalPedido = totalPedido;
        this.cliente = cliente;
        this.orderDetails = orderDetails;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getFechaPedido() {
        return fechaPedido;
    }


    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }


    public int getTotalPedido() {
        return totalPedido;
    }


    public void setTotalPedido(int totalPedido) {
        this.totalPedido = totalPedido;
    }


    public Cliente getCliente() {
        return cliente;
    }


    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }


    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }


    // public String getCodigoIdentificador() {
    //     return codigoIdentificador;
    // }


    // public void setCodigoIdentificador(String codigoIdentificador) {
    //     this.codigoIdentificador = codigoIdentificador;
    // }


    public boolean isActivo() {
        return activo;
    }


    public void setActivo(boolean activo) {
        this.activo = activo;
    }


    public Empresa getEmpresa() {
        return empresa;
    }


    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
}
