package com.crisalis.backendcrisalis.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.crisalis.backendcrisalis.models.Empresa;
import com.crisalis.backendcrisalis.models.Persona;
import com.crisalis.backendcrisalis.models.ServiciosContratados;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ToString
public class DtoEmpresa extends Persona {

   

    private String cuit;

    private String razonSocial;

    private String fechaInicioActividades;


    //private List<ServiciosContratados> serviciosContratados = new ArrayList<>();

    public DtoEmpresa(){

    }

    public DtoEmpresa(String cuit, String razonSocial, String fechaInicioActividades) {
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.fechaInicioActividades = fechaInicioActividades;
    }

    public DtoEmpresa(Empresa empresa) {
        super(empresa.getId(), empresa.getDniCliente(), empresa.getNombre(), empresa.getApellido());
        this.cuit = empresa.getCuit();
        this.razonSocial = empresa.getRazonSocial();
        this.fechaInicioActividades = empresa.getFechaInicioActividades();
      
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


}
