package com.crisalis.backendcrisalis.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crisalis.backendcrisalis.models.OrderDetail;
import com.crisalis.backendcrisalis.repository.OrderDetailRepository;

@Service
@Transactional
public class OrderDetailServices implements IOrderDetailServices {

    @Autowired
    private OrderDetailRepository orderDetailRepository;


    @Override
    public void saveOrderDetail(OrderDetail orderDetail) {
        orderDetailRepository.save(orderDetail);
    }

    @Override
    public void deleteOrderDetail(int id) {
        orderDetailRepository.deleteById(id);
        
    }

    @Override
    public OrderDetail findOrderDetail(int id) {
        OrderDetail orderDetail = orderDetailRepository.findById(id).orElse(null);
        return orderDetail;
    }

    @Override
    public boolean existById(int id) {
        return orderDetailRepository.existsById(id);
    }

    @Override
    public Optional<OrderDetail> getId(int id) {
        return orderDetailRepository.findById(id);
    }

    @Override
    public List<OrderDetail> getOrderDetails() {
        List<OrderDetail> listaOrderDetails = orderDetailRepository.findAll();
        return listaOrderDetails;
    }
    
}
