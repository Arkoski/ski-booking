package com.github.project.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AnotherService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    private LocalDateTime ordersDate;
    private LocalDateTime rentFrom;
    private LocalDateTime rentTo;

    private ServiceType serviceType;

    private boolean servicePaid;

    public AnotherService() {
    }

    public AnotherService(Client client, LocalDateTime ordersDate, LocalDateTime rentFrom, LocalDateTime rentTo, ServiceType serviceType, boolean servicePaid) {
        this.client = client;
        this.ordersDate = ordersDate;
        this.rentFrom = rentFrom;
        this.rentTo = rentTo;
        this.serviceType = serviceType;
        this.servicePaid = servicePaid;
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

    public LocalDateTime getOrdersDate() {
        return ordersDate;
    }

    public void setOrdersDate(LocalDateTime ordersDate) {
        this.ordersDate = ordersDate;
    }

    public LocalDateTime getRentFrom() {
        return rentFrom;
    }

    public void setRentFrom(LocalDateTime rentFrom) {
        this.rentFrom = rentFrom;
    }

    public LocalDateTime getRentTo() {
        return rentTo;
    }

    public void setRentTo(LocalDateTime rentTo) {
        this.rentTo = rentTo;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public boolean isServicePaid() {
        return servicePaid;
    }

    public void setServicePaid(boolean servicePaid) {
        this.servicePaid = servicePaid;
    }
}
