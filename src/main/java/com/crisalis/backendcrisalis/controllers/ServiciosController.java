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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crisalis.backendcrisalis.models.Servicios;
import com.crisalis.backendcrisalis.services.IClienteServices;
import com.crisalis.backendcrisalis.services.IServiciosServices;

@RestController
@CrossOrigin(origins = {"localhost:4200", "localhost"})
public class ServiciosController {
    @Autowired
    IServiciosServices iServiciosServices;

    @GetMapping("/traer/servicios")
    public List<Servicios> getServicios(){
        return iServiciosServices.getServicios();
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

}
