package com.github.project.dto;

import com.github.project.model.AnotherService;
import com.github.project.model.Client;
import com.github.project.model.ServiceType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AnotherServiceDTO {
    private String rentFrom;
    private String rentTo;

    private Client client;

    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;

    public AnotherServiceDTO() {
    }

    public AnotherServiceDTO(AnotherService anotherService) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        this.rentFrom = anotherService.getRentFrom().format(formatter);
        this.rentTo = anotherService.getRentTo().format(formatter);
        this.client = anotherService.getClient();
        this.serviceType = anotherService.getServiceType();
    }

    public String getRentFrom() {
        return rentFrom;
    }

    public void setRentFrom(String rentFrom) {
        this.rentFrom = rentFrom;
    }

    public String getRentTo() {
        return rentTo;
    }

    public void setRentTo(String rentTo) {
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
