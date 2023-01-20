package com.crisalis.backendcrisalis.services;

import java.util.List;
import java.util.Optional;

import com.crisalis.backendcrisalis.models.PedidosClientes;


public interface IPedidosServices {
    public void savePedido(PedidosClientes pedidosClientes);

    public void deletePedido(int id);

    public PedidosClientes findPedido(int id);

    public boolean existById(int id);

    public Optional<PedidosClientes>getId(int id);

    public List<PedidosClientes>getPedidos();
}
