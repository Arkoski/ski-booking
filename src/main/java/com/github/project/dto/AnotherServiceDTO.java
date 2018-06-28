package com.github.project.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class AnotherServiceDTO {


    private Timestamp rentFrom;
    private Timestamp rentTo;

    public AnotherServiceDTO() {
    }

    public AnotherServiceDTO(Timestamp rentFrom, Timestamp rentTo) {
        this.rentFrom = rentFrom;
        this.rentTo = rentTo;
    }

    public Timestamp getRentFrom() {
        return rentFrom;
    }

    public void setRentFrom(Timestamp rentFrom) {
        this.rentFrom = rentFrom;
    }

    public Timestamp getRentTo() {
        return rentTo;
    }

    public void setRentTo(Timestamp rentTo) {
        this.rentTo = rentTo;
    }
}
