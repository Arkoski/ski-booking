package com.github.project.dto;

import java.math.BigDecimal;

public class RoomDTO {
    private Integer roomSize;
    private BigDecimal price;

    public RoomDTO() {
    }

    public RoomDTO(Integer roomSize, BigDecimal price) {
        this.roomSize = roomSize;
        this.price = price;
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
}
