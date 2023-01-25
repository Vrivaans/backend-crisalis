package com.crisalis.backendcrisalis.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crisalis.backendcrisalis.models.OrderE;
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
    
}
