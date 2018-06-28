package com.github.project.dto;

import com.github.project.model.Room;

import java.math.BigDecimal;

public class RoomDTO {
    private Integer roomSize;
    private BigDecimal price;
    private Long id;

    public RoomDTO() {
    }

    public RoomDTO(Room room) {
        this.roomSize = room.getRoomSize();
        this.price = room.getPrice();
        this.id = room.getId();
    }

    public Integer getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(Integer roomSize) {
        this.roomSize = roomSize;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
