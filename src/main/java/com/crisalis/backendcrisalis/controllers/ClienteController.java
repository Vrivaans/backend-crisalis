package com.crisalis.backendcrisalis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crisalis.backendcrisalis.models.Cliente;
import com.crisalis.backendcrisalis.repository.ClienteRepository;
import com.crisalis.backendcrisalis.services.IClienteServices;

@RestController
@CrossOrigin(origins = {"localhost:4200", "localhost"})
public class ClienteController {
    @Autowired
    private IClienteServices iClienteServices;

    @PostMapping("/crear/cliente")
    public String crearCliente(@RequestBody Cliente cliente){
        iClienteServices.saveCliente(cliente);
        return "El usuario se creó correctamente";
    }

    @DeleteMapping("/borrar/cliente/{id}")
    public String deleteCliente(int id){
        iClienteServices.deleteCliente(id);
        return "El cliente fué eliminado";
    }

    @GetMapping("/traer/clientes")
    public List<Cliente>getClientes(){
        return iClienteServices.getClientes();
        
    }

}
