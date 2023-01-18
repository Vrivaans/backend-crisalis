package com.crisalis.backendcrisalis.controllers;

import com.crisalis.backendcrisalis.models.Empresa;
import com.crisalis.backendcrisalis.security.Controller.Mensaje;
import com.crisalis.backendcrisalis.services.IEmpresaServices;

import java.util.List;

import org.hibernate.criterion.EmptyExpression;
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

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "localhost"})
public class EmpresaController {

    @Autowired
    private IEmpresaServices IEmpresaServices;
    
    @GetMapping("/traer/empresas")
    public ResponseEntity<List<Empresa>> getEmpresas(){
        List<Empresa> listaEmpresas = IEmpresaServices.getEmpresas();
        return new ResponseEntity<>(listaEmpresas, HttpStatus.OK);
    }

    @DeleteMapping("/borrar/empresa/{id}")
    public ResponseEntity<?> borrarEmpresa(@PathVariable("id") int id){
        if(!IEmpresaServices.existById(id)){
            return new ResponseEntity(new Mensaje ("No existe el id seleccionado"), HttpStatus.BAD_REQUEST);
        }
        IEmpresaServices.deleteEmpresa(id);
        return new ResponseEntity(new Mensaje("La empresa fué eliminada"), HttpStatus.OK);
        
    }

    @PostMapping("/crear/empresa")
    public ResponseEntity<?> crearEmpresa(@RequestBody Empresa empresa){
        IEmpresaServices.saveEmpresa(empresa);
        return new ResponseEntity(new Mensaje("Se agregó la empresa"), HttpStatus.OK);
    }

    @PutMapping("/actualizar/empresa/{id}") 
    public ResponseEntity<?> actualizarEmpresa(@PathVariable("id") int id, @RequestBody Empresa empresa){
        if(!IEmpresaServices.existById(id)){
            return new ResponseEntity(new Mensaje ("No existe el id"), HttpStatus.NOT_FOUND);
        }

        Empresa empresa1 = IEmpresaServices.getId(id).get();
        empresa1.setCuit(empresa.getCuit());
        empresa1.setFechaInicioActividades(empresa.getFechaInicioActividades());
        empresa1.setRazonSocial(empresa.getRazonSocial());

        IEmpresaServices.saveEmpresa(empresa1);


        return new ResponseEntity(new Mensaje("Se actualizó correctamente"), HttpStatus.OK);
    }

}


