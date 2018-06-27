package com.github.project.model;

import java.math.BigDecimal;

public enum ServiceType {
    INSTRUCTOR (BigDecimal.valueOf(300.00)),
    SKI(BigDecimal.valueOf(60.00));

    private final BigDecimal value;
    ServiceType(BigDecimal serviceType){
        this.value = serviceType;
    }

    public BigDecimal getValue() {
        return value;
    }
}
