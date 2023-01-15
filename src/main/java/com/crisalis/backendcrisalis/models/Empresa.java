package com.crisalis.backendcrisalis.models;

//import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;


@Entity
public class Empresa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String cuit;

    @NotNull
    @Column(name = "razon_social")
    private String razonSocial; 

    @NotNull
    @Column(name = "fecha_inicio_actividades")
    private LocalDate fechaInicioActividades;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Cliente> clientes = new ArrayList<>();

    

    public Empresa() {
    }

    public Empresa(int id, @NotNull @NotNull String cuit, @NotNull String razonSocial, @NotNull LocalDate fechaInicioActividades,
            List<Cliente> clientes) {
        this.id = id;
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.fechaInicioActividades = fechaInicioActividades;
        this.clientes = clientes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDate getFechaInicioActividades() {
        return fechaInicioActividades;
    }

    public void setFechaInicioActividades(LocalDate fechaInicioActividades) {
        this.fechaInicioActividades = fechaInicioActividades;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
}
