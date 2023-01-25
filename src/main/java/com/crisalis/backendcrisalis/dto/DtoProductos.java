package com.crisalis.backendcrisalis.dto;

import com.crisalis.backendcrisalis.models.SuperClaseProductos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;




@ToString
public class DtoProductos extends SuperClaseProductos {public DtoProductos(int id, float precioBase, String nombre, boolean aplicaIva, boolean aplicaIBrutos,
            boolean aplicaGanancias) {
        super(id, precioBase, nombre, aplicaIva, aplicaIBrutos, aplicaGanancias);
    }
    public DtoProductos(){
        
    }

   

}
