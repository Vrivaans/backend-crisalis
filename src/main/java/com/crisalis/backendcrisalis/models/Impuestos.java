package com.crisalis.backendcrisalis.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
public class Impuestos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombreImpuesto;

    private float porcentaje;
    
    public Impuestos (){
        
    }

    public Impuestos(int id, String nombreImpuesto, float porcentaje) {
        this.id = id;
        this.nombreImpuesto = nombreImpuesto;
        this.porcentaje = porcentaje;
    }

    public int getId() {
        return id;  
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreImpuesto() {
        return nombreImpuesto;
    }

    public void setNombreImpuesto(String nombreImpuesto) {
        this.nombreImpuesto = nombreImpuesto;
    }

    public float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }
}
