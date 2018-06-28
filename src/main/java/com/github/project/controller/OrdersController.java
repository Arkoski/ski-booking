package com.github.project.controller;

import com.github.project.dto.OrderDTO;
import com.github.project.model.Order;
import com.github.project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private OrderService orderService;

    @Autowired
    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/{id}")
    public Order findOneById(@PathVariable Long id) {
        return orderService.findById(id);
    }

    @PostMapping
    public OrderDTO create(@RequestBody OrderDTO orderDTO) {
        return orderDTO;
    }


    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }


    @GetMapping
    public Set<Order> findAll() {

        Set<Order> all = orderService.findAll();

        return new HashSet<>(all);
    }

}
