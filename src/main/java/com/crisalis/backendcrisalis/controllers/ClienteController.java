
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

import com.crisalis.backendcrisalis.dto.DtoCliente;
import com.crisalis.backendcrisalis.models.Cliente;

import com.crisalis.backendcrisalis.services.IClienteServices;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "localhost"})
public class ClienteController {
    @Autowired
    private IClienteServices iClienteServices;  

    @PostMapping("/crear/cliente")
    public ResponseEntity<?> crearCliente(@RequestBody Cliente cliente){
        
        iClienteServices.saveCliente(cliente);
        return new ResponseEntity(new Mensaje("El cliente fué agregado"), HttpStatus.OK);
    } 

    @GetMapping("/detail/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable ("id")int id){
        if(!iClienteServices.existById(id)){
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.NOT_FOUND);
        }
        Cliente cliente = iClienteServices.getId(id).get();
        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
        

    }

    @DeleteMapping("/borrar/cliente/{id}")
    public String deleteCliente(@PathVariable int id){
        iClienteServices.deleteCliente(id);
        return "El cliente fué eliminado";
    }
    
    @GetMapping("/traer/clientes")
    public ResponseEntity<List<DtoCliente>>getClientes(){
        List<DtoCliente> lista = iClienteServices.getClientes();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    //@GetMapping("/traer/cliente")
    //public List<Cliente> getClientes(){
    //    return iClienteServices.getClientes();
    //}

    @PutMapping("/actualizar/cliente/{id}")
    public ResponseEntity<?> updateCliente(@PathVariable("id")int id, @RequestBody Cliente cliente){
        //Compruebo si existe el id
        if(!iClienteServices.existById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST); 
        // if(iClienteServices.existsByDniCliente(cliente.getDniCliente()))
        //     return new ResponseEntity(new Mensaje("Hay un usuario con este dni"), HttpStatus.BAD_REQUEST);


                Cliente cliente1 = iClienteServices.getId(id).get();
                cliente1.setApellido(cliente.getApellido());
                cliente1.setDniCliente(cliente.getDniCliente());
                cliente1.setNombre(cliente.getNombre());
                

                iClienteServices.saveCliente(cliente1);

                return new ResponseEntity(new  Mensaje("El usuario fué actualizado correctamente"),HttpStatus.OK);

    }

}