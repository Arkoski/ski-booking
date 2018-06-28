package com.github.project.dto;

import com.github.project.model.Order;

import java.time.LocalDateTime;

public class OrderDTO {

    private LocalDateTime bookFrom;
    private LocalDateTime bookTo;

    private Long roomId;
    private Long clientId;

    public OrderDTO() {
    }

    public OrderDTO(Order order) {
        this.bookFrom = order.getBookFrom().toLocalDateTime();
        this.bookTo = order.getBookTo().toLocalDateTime();
        this.roomId = order.getRoom().getId();
        this.clientId = order.getClient().getId();
    }

    public LocalDateTime getBookFrom() {
        return bookFrom;
    }

    public void setBookFrom(LocalDateTime bookFrom) {
        this.bookFrom = bookFrom;
    }

    public LocalDateTime getBookTo() {
        return bookTo;
    }

    public void setBookTo(LocalDateTime bookTo) {
        this.bookTo = bookTo;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
