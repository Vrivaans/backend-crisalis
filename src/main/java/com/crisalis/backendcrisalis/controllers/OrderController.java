package com.crisalis.backendcrisalis.controllers;

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

import com.crisalis.backendcrisalis.models.OrderDetail;
import com.crisalis.backendcrisalis.models.OrderE;
import com.crisalis.backendcrisalis.security.Controller.Mensaje;
import com.crisalis.backendcrisalis.services.OrderDetailServices;
import com.crisalis.backendcrisalis.services.OrderServices;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "localhost"})
public class OrderController {
    
    @Autowired
    private OrderServices orderServices;

    @Autowired
    private OrderDetailServices orderDetailServices;

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
