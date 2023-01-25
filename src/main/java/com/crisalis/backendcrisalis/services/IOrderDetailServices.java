package com.crisalis.backendcrisalis.services;

import java.util.List;
import java.util.Optional;

import com.crisalis.backendcrisalis.models.OrderDetail;

public interface IOrderDetailServices {
    
    public void saveOrderDetail(OrderDetail orderDetail);

    public void deleteOrderDetail(int id);

    public OrderDetail findOrderDetail(int id);

    public boolean existById(int id);

    public Optional<OrderDetail>getId(int id);

    public List<OrderDetail>getOrderDetails();

}
