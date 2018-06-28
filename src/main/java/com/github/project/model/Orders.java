package com.github.project.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    @OneToOne
    private Room room;

    private LocalDateTime bookDate;
    private LocalDateTime bookFrom;
    private LocalDateTime bookTo;

    private boolean bookPaid;

    public Orders() {
    }

    public Orders(Client client, Room room, LocalDateTime bookDate, LocalDateTime bookFrom, LocalDateTime bookTo, boolean bookPaid) {
        this.client = client;
        this.room = room;
        this.bookDate = bookDate;
        this.bookFrom = bookFrom;
        this.bookTo = bookTo;
        this.bookPaid = bookPaid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDateTime getBookDate() {
        return bookDate;
    }

    public void setBookDate(LocalDateTime bookDate) {
        this.bookDate = bookDate;
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

    public boolean isBookPaid() {
        return bookPaid;
    }

    public void setBookPaid(boolean bookPaid) {
        this.bookPaid = bookPaid;
    }
}
