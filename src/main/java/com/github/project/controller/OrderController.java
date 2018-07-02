package com.github.project.controller;

import com.github.project.dto.OrderDTO;
import com.github.project.model.Order;
import com.github.project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/{id}")
    public OrderDTO findOneById(@PathVariable Long id) {
        return new OrderDTO(orderService.findById(id));
    }

    @PostMapping
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
        return new OrderDTO(orderService.createOrder(orderDTO));
    }


    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

    @GetMapping
    public Set<OrderDTO> findAll() {

        Set<Order> all = orderService.findAll();

        return all.stream().map(order -> new OrderDTO(order)).collect(Collectors.toSet());
    }
}
