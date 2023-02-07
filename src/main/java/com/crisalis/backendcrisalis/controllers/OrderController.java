package com.crisalis.backendcrisalis.controllers;

import com.crisalis.backendcrisalis.dto.DtoOrder;
import com.crisalis.backendcrisalis.dto.DtoOrderDetail;
import com.crisalis.backendcrisalis.models.Cliente;
import com.crisalis.backendcrisalis.models.Empresa;
import com.crisalis.backendcrisalis.models.OrderDetail;
import com.crisalis.backendcrisalis.models.OrderE;
import com.crisalis.backendcrisalis.models.Productos;
import com.crisalis.backendcrisalis.models.Servicios;
import com.crisalis.backendcrisalis.models.ServiciosContratados;
import com.crisalis.backendcrisalis.security.Controller.Mensaje;
import com.crisalis.backendcrisalis.services.CalculoPedido;
import com.crisalis.backendcrisalis.services.ClienteServices;
import com.crisalis.backendcrisalis.services.EmpresaServices;
import com.crisalis.backendcrisalis.services.OrderDetailServices;
import com.crisalis.backendcrisalis.services.OrderServices;
import com.crisalis.backendcrisalis.services.ProductosService;
import com.crisalis.backendcrisalis.services.ServiciosContratadosServices;
import com.crisalis.backendcrisalis.services.ServiciosServices;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins = {"http://localhost:4200", "localhost"})
public class OrderController {
    
    @Autowired
    private OrderServices orderServices;

    @Autowired
    private OrderDetailServices orderDetailServices;

    @Autowired
    private ProductosService productosService;

    @Autowired
    private ServiciosServices serviciosServices;

    @Autowired
    private ClienteServices clienteServices;

    @Autowired
    private EmpresaServices empresaServices;

    @Autowired
    private CalculoPedido calculoPedido;

    @Autowired
    private ServiciosContratadosServices serviciosContratadosServices;

    @GetMapping("/traer/pedidos")
    public ResponseEntity<List<OrderE>> getOrders(){
        List<OrderE> listaOrders = orderServices.getOrders();
        return new ResponseEntity<>(listaOrders, HttpStatus.OK);
    }

    @GetMapping("/traer/detalles/{id}")
    public ResponseEntity<List<DtoOrderDetail>> traerDetalles(@PathVariable("id") int id){
        OrderE order = new OrderE();
        order = orderServices.findOrder(id);
        List<DtoOrderDetail> listaDetallesDto = new ArrayList<>();
        List<OrderDetail> lista = new ArrayList<>();
        lista = order.getOrderDetails();
        listaDetallesDto = orderServices.convertListToDtoList(lista);


        return new ResponseEntity<>(listaDetallesDto, HttpStatus.OK);
    }

    @GetMapping("/estado/pedido/{id}")
    public ResponseEntity<?> estadoPedido(@PathVariable("id") int id){
        if(!orderServices.existById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        OrderE order = orderServices.findOrder(id);
        

        if(order.isActivo()){
            order.setActivo(false);
        } else {
            order.setActivo(true);
        }
        orderServices.saveOrder(order);


        return new ResponseEntity(new Mensaje("Estado del pedido actualizado"), HttpStatus.OK);
    }

    @GetMapping("/traer/pedidos/cliente/{id}")
    public ResponseEntity<List<OrderE>> pedidosCliente(@PathVariable("id") int id){
        List<OrderE> listaPedidosCliente = orderServices.pedidosCliente(id);
        return new ResponseEntity<>(listaPedidosCliente, HttpStatus.OK);
    }
    
    @GetMapping("/traer/pedidos/empresa/{id}")
    public ResponseEntity<List<OrderE>> pedidosEmpresa(@PathVariable("id") int id){
        List<OrderE> listaPedidosEmpresa = orderServices.pedidosEmpresa(id);
        return new ResponseEntity<>(listaPedidosEmpresa, HttpStatus.OK);
    }



    @PostMapping("/crear/dtopedido")
    public ResponseEntity<?> crearDtoOrder(@RequestBody DtoOrder dtoOrder){

        // OrderE order = new OrderE();
        // order = orderServices.converDtoOrderToOrder(dtoOrder);
        // order = calculoPedido.calcularPedido(order);
        // serviciosContratadosServices.saveServiceOfOrder(dtoOrder);
        // orderServices.saveOrder(order);
        

        Cliente clienteAux = new Cliente();
        Empresa empresaAux = new Empresa();
        OrderE order = new OrderE();
        List<OrderDetail> listaItems = new ArrayList<>();
        List<DtoOrderDetail> listaItemsDto = new ArrayList<>();

 
        
        DtoOrderDetail itemPedidoDto = new DtoOrderDetail();

         listaItemsDto = dtoOrder.getOrderDetails();

        // System.out.println(dtoOrder.getOrderDetails());
        // System.out.println(listaItemsDto);
        clienteAux = clienteServices.findByDniCliente(dtoOrder.getDniCliente());
        empresaAux = empresaServices.findEmpresaByCuit(dtoOrder.getCuit());
        // Empiezo a formar el pedido a partir del dto
        order.setFechaPedido(dtoOrder.getFechaPedido());
        //order.setTotalPedido(dtoOrder.getTotalPedido());
        order.setActivo(dtoOrder.isActivo());
        order.setCliente(clienteAux);
        order.setEmpresa(empresaAux);
        
       

        

        //Primero guardo el pedido y después los ítems
        for(int i=0; i < listaItemsDto.size(); i++){

            OrderDetail itemPedido = new OrderDetail();
            //Esto es para los items del detalle
            Productos productoAux = new Productos();
            Servicios servicioAux = new Servicios();

            itemPedidoDto = listaItemsDto.get(i);

            if(itemPedidoDto.isEsServicio()){
                servicioAux = serviciosServices.getServicioByNombre(itemPedidoDto.getNombre());
                productoAux = null;
                itemPedido.setServicios(servicioAux);
                itemPedido.setProductos(productoAux);
                //Guardamos el servicio contratado en la base de datos
                //Primero hay que saber si contrató un cliente o una empresa
                if(clienteAux != null){
                    ServiciosContratados servicioContratado = new ServiciosContratados();
                    servicioContratado.setCliente(clienteAux);
                    servicioContratado.setEmpresa(null);
                    servicioContratado.setServicio(servicioAux);
                    servicioContratado.setActivo(false);
                   
                    serviciosContratadosServices.saveServicioContratado(servicioContratado);
                }

                if(empresaAux != null){
                    ServiciosContratados servicioContratado = new ServiciosContratados();
                    servicioContratado.setCliente(null);
                    servicioContratado.setEmpresa(empresaAux);
                    servicioContratado.setServicio(servicioAux);
                    servicioContratado.setActivo(false);
                    
                    serviciosContratadosServices.saveServicioContratado(servicioContratado);
                }


            } else {
                productoAux = productosService.getProductoByNombre(itemPedidoDto.getNombre());  
                servicioAux = null;
                itemPedido.setServicios(servicioAux);
                itemPedido.setProductos(productoAux);
            }

            
            itemPedido.setCantidad(itemPedidoDto.getCantidad());
            itemPedido.setGarantia(itemPedidoDto.getGarantia());
            itemPedido.setPrecioVenta(itemPedidoDto.getPrecioVenta());
            itemPedido.setSoportePrecio(itemPedidoDto.getSoportePrecio());  
            
            
            listaItems.add(itemPedido);
            orderDetailServices.saveOrderDetail(itemPedido);
            
        }
        order.setOrderDetails(listaItems);

        //Calculamos el pedido primero pero lo guardo en otro objeto
        OrderE orderAux = new OrderE();
        orderAux = calculoPedido.calcularPedido(order);
        order.setTotalPedido(orderAux.getTotalPedido());
        // orderAux.setFechaPedido(order.getFechaPedido());
        // orderAux.setActivo(order.isActivo());
        // orderAux.setCliente(order.getCliente());
        // orderAux.setEmpresa(order.getEmpresa());
        // orderAux.setOrderDetails(listaItems);
        // orderAux.setTotalPedido();

         // Guardo el pedido en DB
         orderServices.saveOrder(order); 

        return new ResponseEntity<>(new Mensaje("El pedido fué creado"), HttpStatus.OK);
    }




}
