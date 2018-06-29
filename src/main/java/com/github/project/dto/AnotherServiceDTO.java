package com.github.project.dto;

import com.github.project.model.AnotherService;
import com.github.project.model.ServiceType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.format.DateTimeFormatter;

public class AnotherServiceDTO {
    private String rentFrom;
    private String rentTo;

    private Long clientId;

    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;

    public AnotherServiceDTO() {
    }

    public AnotherServiceDTO(AnotherService anotherService) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        this.rentFrom = anotherService.getRentFrom().format(formatter);
        this.rentTo = anotherService.getRentTo().format(formatter);
        this.clientId = anotherService.getId();
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

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}
