package com.crisalis.backendcrisalis.dto;

import javax.validation.constraints.NotBlank;

import com.crisalis.backendcrisalis.models.Empresa;

public class DtoCliente {

    @NotBlank
    private int dniCliente;
       
    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    
    //private Empresa empresa;


    public DtoCliente(@NotBlank int dniCliente, @NotBlank String nombre, @NotBlank String apellido) {
        this.dniCliente = dniCliente;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public DtoCliente() {
    }

    public int getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(int dniCliente) {
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
    
}
