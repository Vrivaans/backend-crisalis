package com.crisalis.backendcrisalis.Models;

//import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private int DniCliente;

    @NotNull
    private String nombre;

    @NotNull
    private String apellido;

    public Cliente(@NotNull int dniCliente, @NotNull String nombre, @NotNull String apellido) {
        DniCliente = dniCliente;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Cliente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDniCliente() {
        return DniCliente;
    }

    public void setDniCliente(int dniCliente) {
        DniCliente = dniCliente;
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

    
}
