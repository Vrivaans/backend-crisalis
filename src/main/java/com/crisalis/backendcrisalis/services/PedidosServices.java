package com.crisalis.backendcrisalis.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crisalis.backendcrisalis.dto.DtoPedidos;
import com.crisalis.backendcrisalis.models.PedidosClientes;
import com.crisalis.backendcrisalis.repository.PedidosRepository;

@Service
@Transactional
public class PedidosServices implements IPedidosServices {

    @Autowired
    private PedidosRepository pedidosRepository; 

    @Override
    public void savePedido(PedidosClientes pedidosClientes) {
        pedidosRepository.save(pedidosClientes);
    }

    @Override
    public void deletePedido(int id) {
        pedidosRepository.deleteById(id);
        
    }

    @Override
    public PedidosClientes findPedido(int id) {
        PedidosClientes pedidosClientes = pedidosRepository.findById(id).orElse(null);
        return pedidosClientes;
    }

    @Override
    public boolean existById(int id) {
        return pedidosRepository.existsById(id);
    }

    @Override
    public Optional<PedidosClientes> getId(int id) {
        return pedidosRepository.findById(id);
    }

    @Override
    public List<DtoPedidos> getPedidos() {
        List<PedidosClientes> listaPedidos = pedidosRepository.findAll();
        List<DtoPedidos> listaPedidosDto = new ArrayList<>();
        listaPedidos.forEach(pedido -> listaPedidosDto.add(new DtoPedidos(pedido)));

        return listaPedidosDto;
    }
    
}
