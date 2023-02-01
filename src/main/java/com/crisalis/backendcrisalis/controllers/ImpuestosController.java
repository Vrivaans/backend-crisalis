package com.crisalis.backendcrisalis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.crisalis.backendcrisalis.security.Controller.Mensaje;

import com.crisalis.backendcrisalis.models.Impuestos;
import com.crisalis.backendcrisalis.services.ImpuestosServices;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "localhost"})
public class ImpuestosController {
    
    @Autowired
    private ImpuestosServices impuestosServices;

    @PostMapping("/crear/impuesto")
    public ResponseEntity<?> crearImpuesto(@RequestBody Impuestos impuesto){

        impuestosServices.saveImpuestos(impuesto);
        return new ResponseEntity(new Mensaje("El impuesto fué agregado"), HttpStatus.OK);
    }

}
