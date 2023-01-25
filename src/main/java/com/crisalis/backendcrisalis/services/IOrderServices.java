package com.crisalis.backendcrisalis.services;

import java.util.List;
import java.util.Optional;

import com.crisalis.backendcrisalis.models.OrderE;

public interface IOrderServices {

    public void saveOrder(OrderE order);

    public void deleteOrder(int id);

    public OrderE findOrder(int id);

    public boolean existById(int id);

    public Optional<OrderE>getId(int id);

    public List<OrderE>getOrders();

    
}
