package com.crisalis.backendcrisalis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crisalis.backendcrisalis.dto.DtoServiciosContratados;
import com.crisalis.backendcrisalis.models.ServiciosContratados;
import com.crisalis.backendcrisalis.security.Controller.Mensaje;
import com.crisalis.backendcrisalis.services.ServiciosContratadosServices;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "localhost"})
public class ServiciosContratadosController {

    @Autowired
    private ServiciosContratadosServices serviciosContratadosServices;

    @GetMapping("/traer/servicios-contratados")
    public ResponseEntity<List <DtoServiciosContratados>> getServicios(){
        List<DtoServiciosContratados> dtoListaServicios = serviciosContratadosServices.getServicioContratados();


        return new ResponseEntity<>(dtoListaServicios, HttpStatus.OK);
    }
    
    @GetMapping("/traer/servicios/cliente/{id}")
    public ResponseEntity<List <DtoServiciosContratados>> getServiciosCliente(@PathVariable("id")int id){
        List<DtoServiciosContratados> dtoListaServiciosCliente = serviciosContratadosServices.getServiciosCliente(id);

        return new ResponseEntity<>(dtoListaServiciosCliente, HttpStatus.OK);
    }

    @GetMapping("/traer/servicios/empresa/{id}")
    public ResponseEntity<List <DtoServiciosContratados>> getServiciosEmpresa(@PathVariable("id")int id){
        List<DtoServiciosContratados> dtoListaServiciosCliente = serviciosContratadosServices.getServicioEmpresa(id);

        return new ResponseEntity<>(dtoListaServiciosCliente, HttpStatus.OK);
    }

    @PutMapping("/estado/servicio/{id}")
    public ResponseEntity<?> actualizarServicio(@PathVariable("id") int id){

        if(!serviciosContratadosServices.existById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        ServiciosContratados servicioContratado = serviciosContratadosServices.findServicioContratado(id);
        if(servicioContratado.isActivo()){
            servicioContratado.setActivo(false);
        } else {
            servicioContratado.setActivo(true);
        }
        
        serviciosContratadosServices.saveServicioContratado(servicioContratado);
        return new ResponseEntity(new Mensaje("Estado actualizado"), HttpStatus.OK);
    }



}
