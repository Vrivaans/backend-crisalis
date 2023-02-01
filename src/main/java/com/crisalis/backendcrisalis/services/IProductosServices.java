package com.crisalis.backendcrisalis.services;

import java.util.List;
import java.util.Optional;

import com.crisalis.backendcrisalis.models.Productos;

public interface IProductosServices {
    

    public void saveProducto(Productos producto);

    public void deleteProducto(int id);

    public Productos findProducto(int id);

    public boolean existById(int id);

    public Optional<Productos>getId(int id);

    public List<Productos>getProductos();

    public Productos getProductoByNombre(String nombre); 

}
