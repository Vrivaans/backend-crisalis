package com.crisalis.backendcrisalis.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crisalis.backendcrisalis.models.Impuestos;
import com.crisalis.backendcrisalis.models.OrderDetail;
import com.crisalis.backendcrisalis.models.OrderE;
import com.crisalis.backendcrisalis.models.Productos;
import com.crisalis.backendcrisalis.models.Servicios;

@Service
@Transactional
public class CalculoPedido {

    @Autowired
    private ImpuestosServices impuestosServices;

    

    public OrderE calcularPedido(OrderE order){
        
        float totalPedidoCalculado = 0;
     
        
        
        List<OrderDetail> listaDetalles = new ArrayList<>();
        listaDetalles = order.getOrderDetails();

        //Recorro la lista
        for(int i = 0; i < listaDetalles.size(); i++){

            Impuestos iva = new Impuestos();
            Impuestos ganancias = new Impuestos();
            Impuestos iibb = new Impuestos();
    
    
    
            iva = impuestosServices.findImpuestos(1);
            iibb = impuestosServices.findImpuestos(2);
            ganancias = impuestosServices.findImpuestos(4);

            Productos productoAux = new Productos();
            Servicios servicioAux = new Servicios();

            

            OrderDetail itemPedido = new OrderDetail();
            itemPedido = listaDetalles.get(i);
     
            productoAux = itemPedido.getProductos();
            servicioAux = itemPedido.getServicios();

            //A empezar los cálculos
            if(itemPedido.getProductos()!= null){
                int cantidad;
                int garantia;
                float precioVenta;
                float soportePrecio;
            
                float cantidadFloat;

                cantidad = itemPedido.getCantidad();
                garantia = itemPedido.getGarantia();
                precioVenta = itemPedido.getPrecioVenta();
                soportePrecio = itemPedido.getSoportePrecio();

                float totalItemSinImpuestos;
                float totalItemConImpuestos;

                float ivaPorcentaje = iva.getPorcentaje();
                float iibbPorcentaje = iibb.getPorcentaje();
                float gananciasPorcentaje = ganancias.getPorcentaje();

                float itemIvaImpuesto = 0;
                float itemIBrutosImpuesto = 0;
                float itemGananciasImpuesto = 0;

                cantidadFloat = cantidad;
                totalItemSinImpuestos = (cantidadFloat * precioVenta);
                if(garantia >= 1){
                    totalItemSinImpuestos = totalItemSinImpuestos + (totalItemSinImpuestos * (garantia * 2)) / 100;
                } 
                if(productoAux.isAplicaIva()){
                   itemIvaImpuesto  = (totalItemSinImpuestos * ivaPorcentaje) / 100;
                }
                if(productoAux.isAplicaIBrutos()){
                    itemIBrutosImpuesto = (totalItemSinImpuestos * iibbPorcentaje) / 100;
                }
                if(productoAux.isAplicaGanancias()){
                    itemGananciasImpuesto = (totalItemSinImpuestos * gananciasPorcentaje) / 100;
                }

                totalItemConImpuestos = (totalItemSinImpuestos + itemIvaImpuesto + itemIBrutosImpuesto + itemGananciasImpuesto);

                totalPedidoCalculado += totalItemConImpuestos;

            }
            else if(itemPedido.getServicios() != null){

                int cantidad;
                int garantia;
                float precioVenta;
                float soportePrecio;
            
                float cantidadFloat;

                cantidad = itemPedido.getCantidad();
                garantia = itemPedido.getGarantia();
                precioVenta = itemPedido.getPrecioVenta();
                soportePrecio = itemPedido.getSoportePrecio();

                float totalItemSinImpuestos;
                float totalItemConImpuestos;

                float itemIvaImpuesto = 0;
                float itemIBrutosImpuesto = 0;
                float itemGananciasImpuesto = 0;

                totalItemSinImpuestos = (precioVenta + soportePrecio);
                itemIvaImpuesto = (totalItemSinImpuestos * iva.getPorcentaje()) / 100;
                itemIBrutosImpuesto = (totalItemSinImpuestos * iibb.getPorcentaje()) / 100;
                totalItemConImpuestos = (totalItemSinImpuestos + itemIvaImpuesto + itemIBrutosImpuesto);

                totalPedidoCalculado += totalItemConImpuestos;



            }




        }

        
        order.setTotalPedido(totalPedidoCalculado);



    return order;
    }
    
}
