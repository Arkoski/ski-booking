package com.github.project.service;

import com.github.project.dto.OrdersDTO;
import com.github.project.model.Orders;

import java.util.Set;

public interface OrdersService {

    Orders findById(Long id);
    Set<Orders> findAll();
    Orders createOrder(OrdersDTO orders);
    void deleteOrder(Long id);

}
