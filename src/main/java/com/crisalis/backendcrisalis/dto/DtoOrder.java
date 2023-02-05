package com.crisalis.backendcrisalis.dto;

import java.util.ArrayList;
import java.util.List;

import com.crisalis.backendcrisalis.models.Cliente;
import com.crisalis.backendcrisalis.models.Empresa;
import com.crisalis.backendcrisalis.models.OrderDetail;

import lombok.ToString;

@ToString
public class DtoOrder {
    

    private int id; 



    private String fechaPedido;

    private int totalPedido;

    private boolean activo;
    
    private String dniCliente;

    private String cuit;

    List<DtoOrderDetail> orderDetails = new ArrayList<>();

    public DtoOrder(int id,String fechaPedido, int totalPedido, boolean activo, String dniCliente, String cuit,
            List<DtoOrderDetail> orderDetails) {
        this.id = id;
        this.fechaPedido = fechaPedido;
        this.totalPedido = totalPedido;
        this.activo = activo;
        this.dniCliente = dniCliente;
        this.cuit = cuit;
        this.orderDetails = orderDetails;
    }

    public DtoOrder() {
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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public List<DtoOrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<DtoOrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
    

    // fechaPedido!: string
    // totalPedido!: number
    // activo!: boolean
    // dniCliente!: string
    // cuit!: string
    // dtoOrderDetails!: DtoOrderDetails[]


}
