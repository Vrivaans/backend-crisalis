package com.crisalis.backendcrisalis.controllers;

import com.crisalis.backendcrisalis.models.Empresa;
import com.crisalis.backendcrisalis.security.Controller.Mensaje;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
import com.crisalis.backendcrisalis.models.Empresa;
//import com.crisalis.backendcrisalis.repository.ClienteRepository;
import com.crisalis.backendcrisalis.services.IClienteServices;

@RestController
@CrossOrigin(origins = {"localhost:4200", "localhost"})
public class ClienteController {
    @Autowired
    private IClienteServices iClienteServices;

    //No me sale con el DTO asi que lo tengo que arreglar, tengo problemas con el constructor
    /*@PostMapping("/crear/cliente")
    public ResponseEntity<?> crearCliente(@RequestBody DtoCliente dtoCliente){
        if(StringUtils.isBlank(dtoCliente.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST); 
        }
        if(StringUtils.isBlank(dtoCliente.getApellido())){
            return new ResponseEntity(new Mensaje("El apellido es obligatorio"), HttpStatus.BAD_REQUEST); 
        }
        
        int dniClienteInt = dtoCliente.getDniCliente();
        String dniClienteString = String.valueOf(dniClienteInt);

        if(StringUtils.isBlank(dniClienteString)){
            return new ResponseEntity(new Mensaje("El dni es obligatorio"), HttpStatus.BAD_REQUEST); 
        }

        Cliente cliente = new Cliente(dtoCliente.getDniCliente(), dtoCliente.getNombre(), dtoCliente.getApellido());

        iClienteServices.saveCliente(cliente);
        return new ResponseEntity(new Mensaje("El cliente fué agregado"), HttpStatus.OK);
    } */

    @PostMapping("/crear/cliente")
    public ResponseEntity<?> crearCliente(@RequestBody Cliente cliente){
        
        iClienteServices.saveCliente(cliente);
        return new ResponseEntity(new Mensaje("El cliente fué agregado"), HttpStatus.OK);
    } 

    @DeleteMapping("/borrar/cliente/{id}")
    public String deleteCliente(@PathVariable int id){
        iClienteServices.deleteCliente(id);
        return "El cliente fué eliminado";
    }

    @GetMapping("/traer/clientes")
    public ResponseEntity<List<Cliente>>getClientes(){
        List<Cliente> lista = iClienteServices.getClientes();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PutMapping("/actualizar/cliente/{id}")
    public ResponseEntity<?> updateCliente(@PathVariable("id")int id, @RequestBody Cliente cliente){
        //Compruebo si existe el id
        if(!iClienteServices.existById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST); 
        if(iClienteServices.existsByDniCliente(cliente.getDniCliente()))
            return new ResponseEntity(new Mensaje("Hay un usuario con este dni"), HttpStatus.BAD_REQUEST);

            //Estas validaciones no son correctas porque no manejé IsBlank con los atributos de cliente, deberían ser del DTO
            //if(StringUtils.isBlank(cliente.getApellido()))
            //    return new ResponseEntity(new Mensaje("El apellido es obligatorio"), HttpStatus.BAD_REQUEST);
            //
            //
            //if(StringUtils.isBlank(cliente.getNombre()))
            //    return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        

                Cliente cliente1 = iClienteServices.getId(id).get();
                cliente1.setApellido(cliente.getApellido());
                cliente1.setDniCliente(cliente.getDniCliente());
                cliente1.setNombre(cliente.getNombre());

                iClienteServices.saveCliente(cliente1);

                return new ResponseEntity(new  Mensaje("El usuario fué actualizado correctamente"),HttpStatus.OK);

    }

}
