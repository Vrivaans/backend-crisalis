package com.crisalis.backendcrisalis.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crisalis.backendcrisalis.models.Cliente;
import com.crisalis.backendcrisalis.models.Empresa;
import com.crisalis.backendcrisalis.models.Impuestos;
import com.crisalis.backendcrisalis.models.OrderDetail;
import com.crisalis.backendcrisalis.models.OrderE;
import com.crisalis.backendcrisalis.models.Productos;
import com.crisalis.backendcrisalis.models.Servicios;
import com.crisalis.backendcrisalis.models.ServiciosContratados;
import com.crisalis.backendcrisalis.repository.ServiciosContratadosRepository;

@Service
@Transactional
public class CalculoPedido {

    @Autowired
    private ImpuestosServices impuestosServices;
    
    @Autowired
    private ServiciosContratadosServices serviciosContratadosServices;
    
    @Autowired
    private ServiciosContratadosRepository serviciosContratadosRepository;

    

    public OrderE calcularPedido(OrderE order){
        
        float totalPedidoCalculado = 0;
        float descuentoServicioActivo = 0;

        Cliente clienteAux = new Cliente();
        Empresa empresaAux = new Empresa();
        List<ServiciosContratados> serviciosContratados = new ArrayList<>();
        List<ServiciosContratados> listaServiciosContratadosActivos = new ArrayList<>();

        clienteAux = order.getCliente();
        empresaAux = order.getEmpresa();

        if(clienteAux != null){
            serviciosContratados = serviciosContratadosRepository.ServiciosContratadosPorCliente(clienteAux.getId());
        } else {
            serviciosContratados = serviciosContratadosRepository.ServiciosContratadosPorEmpresa(empresaAux.getId());
        }

        //Pregunta si hay servicio activo para el cliente o empresa
        for(int i = 0; i < serviciosContratados.size(); i++){
            ServiciosContratados servicioContratado = new ServiciosContratados();
            servicioContratado = serviciosContratados.get(i);
            if(servicioContratado.isActivo()){
                listaServiciosContratadosActivos.add(servicioContratado);
            }
        }
        
        
        List<OrderDetail> listaDetalles = new ArrayList<>();
        listaDetalles = order.getOrderDetails();

        //Recorro la lista
        for(int i = 0; i < listaDetalles.size(); i++){

            Impuestos iva = new Impuestos();
            Impuestos ganancias = new Impuestos();
            Impuestos iibb = new Impuestos();
    
    
            //Si no anda buscar por nombre los impuestos entonces voy por los ID
            // iva = impuestosServices.findImpuestos(1);
            // iibb = impuestosServices.findImpuestos(2);
            // ganancias = impuestosServices.findImpuestos(3);

            iva = impuestosServices.findByNombre("iva");
            iibb = impuestosServices.findByNombre("iibb");
            ganancias = impuestosServices.findByNombre("ganancias"); 



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
                if(listaServiciosContratadosActivos.size() >= 1){
                    descuentoServicioActivo += (totalItemSinImpuestos / 10);
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
            if(descuentoServicioActivo > 2500){
                descuentoServicioActivo = 2500;
            }
            
            totalPedidoCalculado = (totalPedidoCalculado - descuentoServicioActivo);


        }
        

        
        order.setTotalPedido(totalPedidoCalculado);



    return order;
    }


}
