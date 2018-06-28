package com.github.project.controller;

import com.github.project.dto.OrdersDTO;
import com.github.project.model.Orders;
import com.github.project.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }


    @GetMapping("/{id}")
    public Orders findOneById(@PathVariable Long id){
        Orders orders = ordersService.findById(id);
        return orders;
    }

    @PostMapping
    public Orders create(@RequestBody OrdersDTO order){
        Orders orders = ordersService.createOrder(order);
        return orders;
    }


    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        ordersService.deleteOrder(id);
    }


    @GetMapping
    public Set<Orders> findAll(){
        Set<Orders> result = new HashSet<>();

        Set<Orders> all = ordersService.findAll();
        all.forEach(b -> result.add(b));

        return result;
    }

}
