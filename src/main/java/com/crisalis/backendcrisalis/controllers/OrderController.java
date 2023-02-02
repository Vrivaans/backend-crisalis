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
    private ServiciosContratadosServices servicesContratadosServices;

    @GetMapping("/traer/pedidos")
    public ResponseEntity<List<OrderE>> getOrders(){
        List<OrderE> listaOrders = orderServices.getOrders();
        return new ResponseEntity<>(listaOrders, HttpStatus.OK);
    }




    @PostMapping("/crear/pedido")
    public ResponseEntity<?> crearOrder(@RequestBody OrderE order){
        
        List<OrderDetail> listaDetalles = new ArrayList<>();
        listaDetalles = order.getOrderDetails();
        
         for(int i=0; i<listaDetalles.size(); i++){
            listaDetalles.get(i);
            OrderDetail orderDetail = listaDetalles.get(i);
            orderDetailServices.saveOrderDetail(orderDetail);
        }    

       

        orderServices.saveOrder(order);
        return new ResponseEntity<>(new Mensaje("El pedido fué creado"), HttpStatus.OK);
    }

    @PostMapping("/crear/dtopedido")
    public ResponseEntity<?> crearDtoOrder(@RequestBody DtoOrder dtoOrder){

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
                    servicesContratadosServices.saveServicioContratado(servicioContratado);
                }

                if(empresaAux != null){
                    ServiciosContratados servicioContratado = new ServiciosContratados();
                    servicioContratado.setCliente(null);
                    servicioContratado.setEmpresa(empresaAux);
                    servicioContratado.setServicio(servicioAux);
                    servicioContratado.setActivo(false);
                    servicesContratadosServices.saveServicioContratado(servicioContratado);
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



    /* Espacio para probar los OrderDetails
     * 
     
    @PostMapping("/crear/detalles")
    //public ResponseEntity <?> crearDetalles(@RequestBody List<OrderDetail> listaDetalles){
        public ResponseEntity <?> crearDetalles(@RequestBody OrderDetail listaDetalles){

            orderDetailServices.saveOrderDetail(listaDetalles);
        //  for(int i=0; i<listaDetalles.size(); i++){
        //     listaDetalles.get(i);
        //     OrderDetail orderDetail = listaDetalles.get(i);
        //     orderDetailServices.saveOrderDetail(orderDetail);
        // }    

        return new ResponseEntity<>(new Mensaje("Se agregaron los items"), HttpStatus.OK);
    }
    */
}
