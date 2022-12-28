package com.crisalis.backendcrisalis.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crisalis.backendcrisalis.models.Productos;
import com.crisalis.backendcrisalis.repository.ProductosRepository;

@Service
@Transactional
public class ProductosService implements IProductosServices{

    @Autowired
    private ProductosRepository productosRepository;

    @Override
    public void saveProducto(Productos producto) {
        
        productosRepository.save(producto);

    }

    @Override
    public void deleteProducto(int id) {
        productosRepository.deleteById(id);
        
    }

    @Override
    public Productos findProducto(int id) {
        Productos producto = productosRepository.findById(id).orElse(null);
        return producto;
    }

    @Override
    public boolean existById(int id) {
        
        return productosRepository.existsById(id);
    }

    @Override
    public Optional<Productos> getId(int id) {
        
        return productosRepository.findById(id);
    }

    @Override
    public List<Productos> getProductos() {
        List<Productos> listaProductos = productosRepository.findAll();
        return listaProductos;
    }
    
}
