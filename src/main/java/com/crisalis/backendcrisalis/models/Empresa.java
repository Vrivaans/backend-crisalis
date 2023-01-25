package com.crisalis.backendcrisalis.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
public class Empresa extends Persona {
    

    
    private String cuit;

    
    @Column(name = "razon_social")
    private String razonSocial; 

    
    @Column(name = "fecha_inicio_actividades")
    private String fechaInicioActividades;
    
  

    @OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ServiciosContratados> serviciosContratados = new ArrayList<>();
    

    public Empresa () {

    }

    public Empresa(int id,  String dniCliente,  String nombre,  String apellido,
             String cuit,  String razonSocial,  String fechaInicioActividades) {
        super(id, dniCliente, nombre, apellido);
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.fechaInicioActividades = fechaInicioActividades;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getFechaInicioActividades() {
        return fechaInicioActividades;
    }

    public void setFechaInicioActividades(String fechaInicioActividades) {
        this.fechaInicioActividades = fechaInicioActividades;
    }

    /* 
    public List<PedidosClientes> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<PedidosClientes> pedidos) {
        this.pedidos = pedidos;
    }
    */

    public List<ServiciosContratados> getServiciosContratados() {
        return serviciosContratados;
    }

    public void setServiciosContratados(List<ServiciosContratados> serviciosContratados) {
        this.serviciosContratados = serviciosContratados;
    }
    
}
