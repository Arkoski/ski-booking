package com.github.project.dto;

import com.github.project.model.Client;
import com.github.project.model.Room;

import java.awt.print.Book;
import java.sql.Timestamp;

public class OrdersDTO {

    private Timestamp bookFrom;
    private Timestamp bookTo;

    private Room room;

    private Client client;

    public OrdersDTO() {
    }

    public OrdersDTO(Timestamp bookFrom, Timestamp bookTo, Room room, Client client) {
        this.bookFrom = bookFrom;
        this.bookTo = bookTo;
        this.room = room;
        this.client = client;
    }

    public Timestamp getBookFrom() {
        return bookFrom;
    }

    public void setBookFrom(Timestamp bookFrom) {
        this.bookFrom = bookFrom;
    }

    public Timestamp getBookTo() {
        return bookTo;
    }

    public void setBookTo(Timestamp bookTo) {
        this.bookTo = bookTo;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
