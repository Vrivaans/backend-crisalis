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
public class Productos extends SuperClaseProductos {
    

    /*
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderDetail>orderDetails = new ArrayList<>(); 
     */
    public Productos(){
        
    }
    public Productos(int id, float precioBase, String nombre, boolean aplicaIva, boolean aplicaIBrutos,
            boolean aplicaGanancias) {
        super(id, precioBase, nombre, aplicaIva, aplicaIBrutos, aplicaGanancias);
        
    }




    
}
