package com.crisalis.backendcrisalis.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.MappedSuperclass;
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
public class Productos extends SuperClaseProductos {
    


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<DetallesPedidos>detallesPedidos = new HashSet<>();

    public Productos(int id, float precioBase, String nombre, boolean aplicaIva, boolean aplicaIBrutos, boolean aplicaGanancias) {
        super(id, precioBase, nombre, aplicaIva, aplicaIBrutos, aplicaGanancias);
        
    }

    
}
