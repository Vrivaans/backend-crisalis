package com.crisalis.backendcrisalis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crisalis.backendcrisalis.models.Productos;
import com.crisalis.backendcrisalis.services.IProductosServices;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "localhost"})
public class ProductosController {
    @Autowired
    private IProductosServices iProductosServices;

    @PostMapping("/crear/producto")
    public String crearProducto(@RequestBody Productos producto){
        iProductosServices.saveProducto(producto);
        return "Producto agregado exitosamente";
    }

    /*@DeleteMapping("/borrar/producto/{id}")
    public String borrarProducto(int id){
        iProductosServices.deleteProducto(id);
            return "Se borró el producto"; 
    }*/
    @DeleteMapping("/borrar/producto/{id}")
    public String borrarProducto(@PathVariable int id){
        iProductosServices.deleteProducto(id);
        return "El producto fué eliminado";
    }

    
    @GetMapping("/traer/productos")
    public ResponseEntity<List<Productos>>getProductos(){
        List<Productos> lista = iProductosServices.getProductos();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    

}
