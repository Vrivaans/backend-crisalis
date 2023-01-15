package com.crisalis.backendcrisalis.models;

import java.util.ArrayList;
import java.util.List;
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
import javax.validation.constraints.NotNull;

//import javax.annotation.Generated;

@Entity
public class Cliente {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "dni_cliente")
    private String dniCliente;

    @NotNull    
    private String nombre;

    @NotNull
    private String apellido;

    private String cuit;


    @ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;


    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PedidosClientes> pedidos = new ArrayList<>();

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ServiciosContratados> serviciosContratados = new ArrayList<>();


    public Cliente(int id, @NotNull String dniCliente, @NotNull String nombre, @NotNull String apellido, String cuit, Empresa empresa) {
        this.id = id;
        this.dniCliente = dniCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.empresa = empresa;
        this.cuit = cuit;
    }

    public Cliente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCuit(){
        return cuit;
    }

    public void setCuit(String cuit){
        this.cuit = cuit;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<PedidosClientes> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<PedidosClientes> pedidos) {
        this.pedidos = pedidos;
    }
    
    public List<ServiciosContratados> getServiciosContratados(){
        return serviciosContratados;
    }

    public void setServiciosContratados(List<ServiciosContratados> serviciosContratados){
        this.serviciosContratados = serviciosContratados;
    }

    

    
}
