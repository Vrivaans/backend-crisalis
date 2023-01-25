package com.crisalis.backendcrisalis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crisalis.backendcrisalis.models.OrderE;
import com.crisalis.backendcrisalis.security.Controller.Mensaje;
import com.crisalis.backendcrisalis.services.OrderServices;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "localhost"})
public class OrderController {
    
    @Autowired
    private OrderServices orderServices;

    @GetMapping("/traer/pedidos")
    public ResponseEntity<List<OrderE>> getOrders(){
        List<OrderE> listaOrders = orderServices.getOrders();
        return new ResponseEntity<>(listaOrders, HttpStatus.OK);
    }

    @PostMapping("/crear/pedido")
    public ResponseEntity<?> crearOrder(@RequestBody OrderE order){
        orderServices.saveOrder(order);
        return new ResponseEntity<>(new Mensaje("El pedido fué creado"), HttpStatus.OK);
    }

}
