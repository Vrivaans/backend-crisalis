package com.crisalis.backendcrisalis.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Productos extends SuperClaseProductos {
    


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DetallesPedidos>detallesPedidos = new ArrayList<>();

    public Productos(int id, float precioBase, String nombre, boolean aplicaIva, boolean aplicaIBrutos,
            boolean aplicaGanancias, List<DetallesPedidos> detallesPedidos) {
        super(id, precioBase, nombre, aplicaIva, aplicaIBrutos, aplicaGanancias);
        this.detallesPedidos = detallesPedidos;
    }

    public List<DetallesPedidos> getDetallesPedidos() {
        return detallesPedidos;
    }

    public void setDetallesPedidos(List<DetallesPedidos> detallesPedidos) {
        this.detallesPedidos = detallesPedidos;
    }



    
}
