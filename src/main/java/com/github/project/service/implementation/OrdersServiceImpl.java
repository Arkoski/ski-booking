package com.github.project.service.implementation;

import com.github.project.dto.OrdersDTO;
import com.github.project.model.Orders;
import com.github.project.model.Room;
import com.github.project.repository.OrdersRepository;
import com.github.project.repository.RoomRepository;
import com.github.project.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
public class OrdersServiceImpl implements OrdersService {

    private OrdersRepository ordersRepository;
    private RoomRepository roomRepository;

    @Autowired
    public OrdersServiceImpl(OrdersRepository ordersRepository, RoomRepository roomRepository) {
        this.ordersRepository = ordersRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public Orders findById(Long id) {
        return ordersRepository.findOne(id);
    }

    @Override
    public Set<Orders> findAll() {
        return new HashSet<>(ordersRepository.findAll());
    }

    @Override
    public Orders createOrder(OrdersDTO orders) {
        Orders order = new Orders();
        order.setBookDate(Timestamp.valueOf(LocalDateTime.now()));
        order.setBookFrom(orders.getBookFrom());
        order.setBookTo(orders.getBookTo());
        order.setBookPrice(roomRepository.findOne(orders.getRoom().getId()).getPrice());
        order.setBookPaid(false);
        order.setClient(orders.getClient());
        order.setRoom(orders.getRoom());

        Orders save = ordersRepository.save(order);

        return save;
    }

    @Override
    public void deleteOrder(Long id) {
        deleteOrder(id);
    }
}
