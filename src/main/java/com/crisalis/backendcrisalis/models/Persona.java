
package com.crisalis.backendcrisalis.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public class Persona {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

  
    @Column(name = "dni_cliente", unique = true)
    private String dniCliente;

      
    private String nombre;

    
    private String apellido;

    public Persona() {
    }

    public Persona(int id, String dniCliente,  String nombre,  String apellido) {
        this.id = id;
        this.dniCliente = dniCliente;
        this.nombre = nombre;
        this.apellido = apellido;
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

}
