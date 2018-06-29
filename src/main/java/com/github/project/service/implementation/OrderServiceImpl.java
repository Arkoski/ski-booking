package com.github.project.service.implementation;

import com.github.project.dto.OrderDTO;
import com.github.project.model.Order;
import com.github.project.repository.ClientRepository;
import com.github.project.repository.OrderRepository;
import com.github.project.repository.RoomRepository;
import com.github.project.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger LOG = LoggerFactory.getLogger(OrderServiceImpl.class);

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

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        //LocalDateTime dateTime = LocalDateTime.parse(str, formatter);

        Order order = new Order();
        order.setBookDate(LocalDateTime.now());
        order.setBookFrom(LocalDateTime.parse(orders.getBookFrom(), formatter));
        order.setBookTo(LocalDateTime.parse(orders.getBookTo(), formatter));
        order.setBookPaid(false);
        order.setClient(clientRepository.findOne(orders.getClientId()));
        order.setRoom(roomRepository.findOne(orders.getRoomId()));
        order.setBookPrice(roomRepository.getOne(orders.getRoomId()).getPrice());

        LOG.info("zapisuje");
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        deleteOrder(id);
    }
}
