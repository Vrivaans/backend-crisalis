package com.crisalis.backendcrisalis.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crisalis.backendcrisalis.dto.DtoCliente;
import com.crisalis.backendcrisalis.models.Cliente;
import com.crisalis.backendcrisalis.repository.ClienteRepository;

@Service
@Transactional
public class ClienteServices implements IClienteServices {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void saveCliente(Cliente cliente) {
        clienteRepository.save(cliente);
        
    }

    @Override
    public void deleteCliente(int id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Cliente findCliente(int id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        return cliente;
    }

    @Override
    public boolean existById(int id) {
        
        return clienteRepository.existsById(id);
    }

    @Override
    public Optional<Cliente> getId(int id) {
        
        return clienteRepository.findById(id);
    }

    @Override
    public List<DtoCliente> getClientes() {
        List<Cliente> listaClientes = clienteRepository.findAll();
        List<DtoCliente> listaClientesDto = new ArrayList<>();
        listaClientes.forEach(cliente -> listaClientesDto.add(new DtoCliente(cliente)));

        return listaClientesDto;
    }

    @Override
    public boolean existsByDniCliente(String dniCliente) {
        return clienteRepository.existsByDniCliente(dniCliente);
    }

    
    
}
