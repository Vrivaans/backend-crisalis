package com.crisalis.backendcrisalis.dto;

import java.util.ArrayList;
import java.util.List;

import com.crisalis.backendcrisalis.models.Cliente;
import com.crisalis.backendcrisalis.models.PedidosClientes;
import com.crisalis.backendcrisalis.models.Persona;





public class DtoCliente extends Persona {

    //private DtoPedidos dtoPedidos;

    //private Set<PedidosClientes> pedidos = new HashSet<>();
    
    private List<DtoPedidos> listaPedidosConstructor = new ArrayList<>(); //Este tengo que usar
    
    //private Set<ServiciosContratados> serviciosContratados = new HashSet<>();

    public DtoCliente(){

    }
    
    public DtoCliente(Cliente cliente){
        super(cliente.getId(), cliente.getDniCliente(), cliente.getNombre(), cliente.getApellido());
        
        //this.serviciosContratados = getServiciosDto(cliente.getServiciosContratados());
    }

    
    /* Tengo que crear el constructor primero, pero voy a priorizar los pedidos */
    /* public List<DtoServicio> getServiciosDto(List<ServiciosContratados> serviciosContratados) {
        List<ServiciosContratados> listaServiciosContratadosDto = new ArrayList<>();
        serviciosContratados.forEach(servicioContratado -> listaServiciosContratadosDto.add(new DtoServicio(servicioContratado)));

        return listaServiciosContratadosDto;
    } */


    public List<DtoPedidos> getListaPedidosConstructor() {
        return listaPedidosConstructor;
    }


    public void setListaPedidosConstructor(List<DtoPedidos> listaPedidosConstructor) {
        this.listaPedidosConstructor = listaPedidosConstructor;
    }


    /* public DtoPedidos obtenerDtoPedido(PedidosClientes pedido){
        DtoPedidos dtoPedidosAux = new DtoPedidos(pedido);
        return dtoPedidosAux;
    } */


}
