package com.github.project.dto;

import com.github.project.model.AnotherService;
import com.github.project.model.Client;
import com.github.project.model.ServiceType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.sql.Timestamp;

public class AnotherServiceDTO {
    private Timestamp rentFrom;
    private Timestamp rentTo;

    private Client client;

    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;

    public AnotherServiceDTO() {
    }

    public AnotherServiceDTO(AnotherService anotherService) {
        this.rentFrom = anotherService.getRentFrom();
        this.rentTo = anotherService.getRentTo();
        this.client = anotherService.getClient();
        this.serviceType = anotherService.getServiceType();
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}
