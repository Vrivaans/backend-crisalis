package com.crisalis.backendcrisalis.controllers;

import com.crisalis.backendcrisalis.security.Controller.Mensaje;
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

import com.crisalis.backendcrisalis.models.Servicios;
import com.crisalis.backendcrisalis.services.IClienteServices;
import com.crisalis.backendcrisalis.services.IServiciosServices;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "localhost"})
public class ServiciosController {
    @Autowired
    IServiciosServices iServiciosServices;

    @GetMapping("/traer/servicios")
    public ResponseEntity<List<Servicios>>getServicios(){
        List<Servicios> lista = iServiciosServices.getServicios();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping("/crear/servicio")
    public ResponseEntity<?> crearServicio(@RequestBody Servicios servicio){
        iServiciosServices.saveServicio(servicio);
        return new ResponseEntity(new Mensaje("El servicio fué creado"), HttpStatus.OK);
    }

    @DeleteMapping("/borrar/servicio/{id}")
    public ResponseEntity<?> borrarServicio (@PathVariable int id){

        iServiciosServices.deleteServicio(id);
        return new ResponseEntity(new Mensaje("El servicio fué borrado"), HttpStatus.OK);
    }

    @GetMapping("/detail-servicio/{id}")
    public ResponseEntity<Servicios> getById(@PathVariable ("id")int id){
        if(!iServiciosServices.existById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.NOT_FOUND);
        }
        Servicios servicio = iServiciosServices.getId(id).get();
        return new ResponseEntity<Servicios>(servicio, HttpStatus.OK);
        

    }


    @PutMapping("/actualizar/servicio/{id}")
    public ResponseEntity<?> updateProducto(@PathVariable("id")int id, @RequestBody Servicios servicio){
        //Compruebo si existe el id
        if(!iServiciosServices.existById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST); 
        // if(iClienteServices.existsByDniCliente(cliente.getDniCliente()))
        //     return new ResponseEntity(new Mensaje("Hay un usuario con este dni"), HttpStatus.BAD_REQUEST);


                // Cliente cliente1 = iClienteServices.getId(id).get();
                // cliente1.setApellido(cliente.getApellido());
                // cliente1.setDniCliente(cliente.getDniCliente());
                // cliente1.setNombre(cliente.getNombre());
                

                // iClienteServices.saveCliente(cliente1);

                Servicios servicio1 = iServiciosServices.getId(id).get();
                servicio1.setNombre(servicio.getNombre());
                servicio1.setPrecioBase(servicio.getPrecioBase());
                servicio1.setAplicaGanancias(servicio.isAplicaGanancias());
                servicio1.setAplicaIBrutos(servicio.isAplicaIBrutos());
                servicio1.setAplicaIva(servicio.isAplicaIva());
                servicio1.setSoportePrecio(servicio.getSoportePrecio());
                iServiciosServices.saveServicio(servicio1);


                return new ResponseEntity(new  Mensaje("El usuario fué actualizado correctamente"),HttpStatus.OK);

    }



}
