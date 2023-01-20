package com.crisalis.backendcrisalis.services;

import java.util.List;
import java.util.Optional;

import com.crisalis.backendcrisalis.models.DetallesPedidos;

public interface IDetallesPedidosServices {
    

    public void saveItem(DetallesPedidos detallesPedidos);
    public DetallesPedidos findDetalle(int id);
    public void deleteItem(int id);
    public Optional<DetallesPedidos>getId(int id);
    public List<DetallesPedidos>getDetalles();


}
