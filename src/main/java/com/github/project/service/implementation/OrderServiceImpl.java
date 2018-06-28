package com.github.project.service.implementation;

import com.github.project.dto.OrderDTO;
import com.github.project.model.Order;
import com.github.project.repository.ClientRepository;
import com.github.project.repository.OrderRepository;
import com.github.project.repository.RoomRepository;
import com.github.project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private RoomRepository roomRepository;
    private ClientRepository clientRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, RoomRepository roomRepository, ClientRepository clientRepository) {
        this.orderRepository = orderRepository;
        this.roomRepository = roomRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findOne(id);
    }

    @Override
    public Set<Order> findAll() {
        return new HashSet<>(orderRepository.findAll());
    }

    @Override
    public Order createOrder(OrderDTO orders) {
        Order order = new Order();
        order.setBookDate(Timestamp.valueOf(LocalDateTime.now()));
        order.setBookFrom(Timestamp.valueOf(orders.getBookFrom()));
        order.setBookTo(Timestamp.valueOf(orders.getBookTo()));
        order.setBookPaid(false);
        order.setClient(clientRepository.findOne(orders.getClientId()));
        order.setRoom(roomRepository.findOne(orders.getRoomId()));
        order.setBookPrice(roomRepository.getOne(orders.getRoomId()).getPrice());

        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        deleteOrder(id);
    }
}
