package com.crisalis.backendcrisalis.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crisalis.backendcrisalis.dto.DtoOrderDetail;
import com.crisalis.backendcrisalis.models.OrderDetail;
import com.crisalis.backendcrisalis.models.OrderE;
import com.crisalis.backendcrisalis.models.Productos;
import com.crisalis.backendcrisalis.models.Servicios;
import com.crisalis.backendcrisalis.repository.OrderRepository;

@Service
@Transactional
public class OrderServices implements IOrderServices {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void saveOrder(OrderE order) {
        orderRepository.save(order);
        
    }

    @Override
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }

    @Override
    public OrderE findOrder(int id) {
        OrderE order = orderRepository.findById(id).orElse(null);
        return order;
    }

    @Override
    public boolean existById(int id) {
        return orderRepository.existsById(id);
    }

    @Override
    public Optional<OrderE> getId(int id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<OrderE> getOrders() {
        List<OrderE> listaOrders = orderRepository.findAll();
        return listaOrders;
    }

    @Override
    public List<DtoOrderDetail> convertListToDtoList(List<OrderDetail> lista) {
        List<DtoOrderDetail> listaDetallesDto = new ArrayList<>();
        
        for(int i = 0; i < lista.size(); i++){
            Productos productoAux = new Productos();
            Servicios servicioAux = new Servicios();
            OrderDetail itemPedido = new OrderDetail();
            DtoOrderDetail itemPedidoDto = new DtoOrderDetail();

            itemPedido = lista.get(i);

            itemPedidoDto.setCantidad(itemPedido.getCantidad());
            itemPedidoDto.setGarantia(itemPedido.getGarantia());
            itemPedidoDto.setPrecioVenta(itemPedido.getPrecioVenta());
            itemPedidoDto.setSoportePrecio(itemPedido.getSoportePrecio());
            if(itemPedido.getProductos() != null){
                productoAux = itemPedido.getProductos();

                itemPedidoDto.setNombre(productoAux.getNombre());
                itemPedidoDto.setEsServicio(false);
            } else {
                servicioAux = itemPedido.getServicios();
                itemPedidoDto.setNombre(servicioAux.getNombre());
                itemPedidoDto.setEsServicio(true);
            }
            listaDetallesDto.add(itemPedidoDto);


        }

        return listaDetallesDto;
    }

    @Override
    public List<OrderE> pedidosCliente(int id) {
        List<OrderE> listaPedidosCliente = orderRepository.pedidosCliente(id);
        return listaPedidosCliente;

    }

    @Override
    public List<OrderE> pedidosEmpresa(int id) {
        List<OrderE> listaPedidosEmpresa = orderRepository.pedidosEmpresa(id);
        return listaPedidosEmpresa;
    }

    
    
}
