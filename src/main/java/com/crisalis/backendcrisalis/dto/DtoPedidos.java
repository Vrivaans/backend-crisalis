package com.crisalis.backendcrisalis.dto;

import com.crisalis.backendcrisalis.models.Cliente;
import com.crisalis.backendcrisalis.models.Empresa;
import com.crisalis.backendcrisalis.models.PedidosClientes;

public class DtoPedidos {
    
    
    private int id;
    private String fechaPedido;
    private DtoCliente dtoCliente;
    private DtoEmpresa dtoEmpresa;
    //private List<DetallesPedidos> detallesPedidos = new ArrayList<>();

    public DtoPedidos (){
        
    }
    public DtoPedidos (PedidosClientes pedidosCliente){
        this.id = pedidosCliente.getId();
        this.fechaPedido = pedidosCliente.getFechaPedido();
        //this.dtoCliente = obtenerDtoCliente(pedidosCliente.getCliente());
        //this.dtoEmpresa = obtenerDtoEmpresa(pedidosCliente.getEmpresa());
    } 

    public DtoPedidos crearPedidoDto(PedidosClientes pedidosCliente){
        DtoPedidos dtoPedido = new DtoPedidos();
        dtoPedido.id = pedidosCliente.getId();
        dtoPedido.fechaPedido = pedidosCliente.getFechaPedido();
        return dtoPedido;
    }


    /* Este fragmento de código es para obtener el cliente que realizó este pedido.
     * Lo que resuelve esto es el bucle infinito que se hacía al llamar al objeto (en este caso cliente)
     * Y el cliente volvía a llamar al pedido, y así sucesivamente.
     * Entonces este código crea un objeto DtoCliente, al cual se le quita los métodos que almacenan
     * listas (tipo Set o List) que vuelven a llamar a los objetos de tipo Pedido, que
     * a su vez estos objetos con listas similares vuelven a llamar a los objetos Cliente
     * provocando el bucle.
     * Esta función es necesaria porque hacerla de forma normal en el constructor de arriba
     * no es posible porque ese constructor (del DtoCliente) no acepta las listas que trae
     * (se las quité, en su clase se pueden ver comentadas) 
     * Entonces esta función retorna el obj DtoCliente sin esos métodos molestos. 
     */
    public DtoCliente obtenerDtoCliente(Cliente cliente){
        DtoCliente dtoClienteAux = new DtoCliente(cliente);
        return dtoClienteAux;
    }
    public DtoEmpresa obtenerDtoEmpresa(Empresa empresa){
        DtoEmpresa dtoEmpresaAux = new DtoEmpresa(empresa);
        return dtoEmpresaAux;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getFechaPedido() {
        return fechaPedido;
    }


    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }


    public DtoCliente getDtoCliente() {
        return dtoCliente;
    }


    public void setDtoCliente(DtoCliente dtoCliente) {
        this.dtoCliente = dtoCliente;
    }

}
