package com.github.project.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
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

    private Timestamp bookDate;
    private Timestamp bookFrom;
    private Timestamp bookTo;

    private boolean bookPaid;

    private BigDecimal bookPrice;

    public Orders() {
    }

    public Orders(Client client, Room room, Timestamp bookDate, Timestamp bookFrom, Timestamp bookTo, boolean bookPaid, BigDecimal bookPrice) {
        this.client = client;
        this.room = room;
        this.bookDate = bookDate;
        this.bookFrom = bookFrom;
        this.bookTo = bookTo;
        this.bookPaid = bookPaid;
        this.bookPrice = bookPrice;
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

    public Timestamp getBookDate() {
        return bookDate;
    }

    public void setBookDate(Timestamp bookDate) {
        this.bookDate = bookDate;
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

    public boolean isBookPaid() {
        return bookPaid;
    }

    public void setBookPaid(boolean bookPaid) {
        this.bookPaid = bookPaid;
    }

    public BigDecimal getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(BigDecimal bookPrice) {
        this.bookPrice = bookPrice;
    }
}
