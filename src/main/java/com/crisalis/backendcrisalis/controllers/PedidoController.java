package com.crisalis.backendcrisalis.controllers;

import com.crisalis.backendcrisalis.models.PedidosClientes;
import com.crisalis.backendcrisalis.security.Controller.Mensaje;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.crisalis.backendcrisalis.services.IPedidosServices;




@RestController
@CrossOrigin(origins = {"http://localhost:4200", "localhost"})
public class PedidoController {

    @Autowired
    private IPedidosServices iPedidosServices;

    @PostMapping("/crear/pedido")
    public ResponseEntity<?> crearPedido(@RequestBody PedidosClientes pedidosCliente){
        
        iPedidosServices.savePedido(pedidosCliente);
        return new ResponseEntity(new Mensaje("El pedido fué agregado"), HttpStatus.OK);
    } 

    @GetMapping("/traer/pedidos")
    public ResponseEntity<List<PedidosClientes>>getPedidos(){
        List<PedidosClientes> listaPedidos = iPedidosServices.getPedidos();
        return new ResponseEntity<>(listaPedidos, HttpStatus.OK);
    }




}
