package com.crisalis.backendcrisalis.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crisalis.backendcrisalis.models.DetallesPedidos;
import com.crisalis.backendcrisalis.repository.DetallesPedidosRepository;

@Service
@Transactional
public class DetallesServices implements IDetallesPedidosServices {

    @Autowired
    private DetallesPedidosRepository detallesPedidosRepository;

    @Override
    public void saveItem(DetallesPedidos detallesPedidos) {
        detallesPedidosRepository.save(detallesPedidos);
        
    }

    @Override
    public DetallesPedidos findDetalle(int id) {
        DetallesPedidos detallesPedidos = detallesPedidosRepository.findById(id).orElse(null);
        return detallesPedidos;
    }

    @Override
    public void deleteItem(int id) {
        detallesPedidosRepository.deleteById(id);
    }

    @Override
    public Optional<DetallesPedidos> getId(int id) {
        return detallesPedidosRepository.findById(id);
    }

    @Override
    public List<DetallesPedidos> getDetalles() {
        List<DetallesPedidos> listaDetalles = detallesPedidosRepository.findAll();
        return listaDetalles;
    }
    
}
