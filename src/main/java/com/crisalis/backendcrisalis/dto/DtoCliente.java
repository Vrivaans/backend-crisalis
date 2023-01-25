package com.crisalis.backendcrisalis.dto;

import java.util.ArrayList;
import java.util.List;

import com.crisalis.backendcrisalis.models.Cliente;
import com.crisalis.backendcrisalis.models.Persona;
import com.crisalis.backendcrisalis.models.ServiciosContratados;

import lombok.ToString;




@ToString
public class DtoCliente extends Persona {

    //private DtoPedidos dtoPedidos;

    //private Set<PedidosClientes> pedidos = new HashSet<>();
    
    //private List<DtoPedidos> listaPedidos= new ArrayList<>(); //Este tengo que usar
    
    //private List<ServiciosContratados> serviciosContratados = new ArrayList<>();

  
    public DtoCliente(){

    }
    
    public DtoCliente(Cliente cliente){
        super(cliente.getId(), cliente.getDniCliente(), cliente.getNombre(), cliente.getApellido());
        //this.listaPedidos = cliente.getPedidos();
        //this.serviciosContratados = cliente.getServiciosContratados();
        
        //this.serviciosContratados = getServiciosDto(cliente.getServiciosContratados());
    }
    
    /* Tengo que crear el constructor primero, pero voy a priorizar los pedidos */
    /* public List<DtoServicio> getServiciosDto(List<ServiciosContratados> serviciosContratados) {
        List<ServiciosContratados> listaServiciosContratadosDto = new ArrayList<>();
        serviciosContratados.forEach(servicioContratado -> listaServiciosContratadosDto.add(new DtoServicio(servicioContratado)));

        return listaServiciosContratadosDto;
    } */

    /*

    public List<DtoPedidos> getListaPedidos() {
        return listaPedidos;
    }


    public void setListaPedidos (List<DtoPedidos> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public List<ServiciosContratados> getServiciosContratados() {
        return serviciosContratados;
    }

    public void setServiciosContratados(List<ServiciosContratados> serviciosContratados) {
        this.serviciosContratados = serviciosContratados;
    }
     */



    /* public DtoPedidos obtenerDtoPedido(PedidosClientes pedido){
        DtoPedidos dtoPedidosAux = new DtoPedidos(pedido);
        return dtoPedidosAux;
    } */


}
