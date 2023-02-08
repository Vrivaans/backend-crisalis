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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crisalis.backendcrisalis.models.Productos;
import com.crisalis.backendcrisalis.security.Controller.Mensaje;
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
    // @GetMapping("/detail/{id}")
    // public ResponseEntity<Productos> getById(@PathVariable ("id")int id){
    //     if(!iProductosServices.existById(id)){
    //         return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.NOT_FOUND);
    //     }
    //     Productos producto = iProductosServices.getId(id).get();
    //     return new ResponseEntity<Productos>(producto, HttpStatus.OK);
        

    // }





    @PutMapping("/actualizar/producto/{id}")
    public ResponseEntity<?> updateProducto(@PathVariable("id")int id, @RequestBody Productos producto){
        //Compruebo si existe el id
        if(!iProductosServices.existById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST); 
        // if(iClienteServices.existsByDniCliente(cliente.getDniCliente()))
        //     return new ResponseEntity(new Mensaje("Hay un usuario con este dni"), HttpStatus.BAD_REQUEST);


                // Cliente cliente1 = iClienteServices.getId(id).get();
                // cliente1.setApellido(cliente.getApellido());
                // cliente1.setDniCliente(cliente.getDniCliente());
                // cliente1.setNombre(cliente.getNombre());
                

                // iClienteServices.saveCliente(cliente1);

                Productos producto1 = new Productos();
                producto1.setNombre(producto.getNombre());
                producto1.setPrecioBase(producto.getPrecioBase());
                producto1.setAplicaGanancias(producto.isAplicaGanancias());
                producto1.setAplicaIBrutos(producto.isAplicaIBrutos());
                producto1.setAplicaIva(producto.isAplicaIva());


                return new ResponseEntity(new  Mensaje("El usuario fué actualizado correctamente"),HttpStatus.OK);

    }

    

}
