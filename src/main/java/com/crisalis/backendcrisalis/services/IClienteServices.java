package com.crisalis.backendcrisalis.services;

import java.util.List;
import java.util.Optional;

import com.crisalis.backendcrisalis.models.Cliente;

public interface IClienteServices {
    public void saveCliente(Cliente cliente);

    public void deleteCliente(int id);

    public Cliente findCliente(int id);

    public boolean existById(int id);

    public Optional<Cliente>getId(int id);

    public List<Cliente>getClientes();

    public boolean existsByDniCliente(String dniCliente);

    //public Optional<Cliente>findByDniCliente(String dniCliente);

    
}
