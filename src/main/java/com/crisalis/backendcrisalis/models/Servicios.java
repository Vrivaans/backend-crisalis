package com.crisalis.backendcrisalis.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Servicios extends SuperClaseProductos {
    
    @Column(name = "soporte_precio")
    private float soportePrecio;

    @Column(name = "es_especial")
    private boolean esEspecial;

    

    @OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL)
    private List<ServiciosContratados> serviciosContratados;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DetallesPedidos>detallesPedidos = new ArrayList<>();

}
