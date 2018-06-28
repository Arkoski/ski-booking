package com.github.project.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
public class AnotherService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    private Timestamp rentDate;
    private Timestamp rentFrom;
    private Timestamp rentTo;

    private ServiceType serviceType;

    private boolean servicePaid;

    private BigDecimal servicePrice;

    public AnotherService() {
    }

    public AnotherService(Client client, Timestamp rentDate, Timestamp rentFrom, Timestamp rentTo, ServiceType serviceType, boolean servicePaid, BigDecimal servicePrice) {
        this.client = client;
        this.rentDate = rentDate;
        this.rentFrom = rentFrom;
        this.rentTo = rentTo;
        this.serviceType = serviceType;
        this.servicePaid = servicePaid;
        this.servicePrice = servicePrice;
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

    public Timestamp getRentDate() {
        return rentDate;
    }

    public void setRentDate(Timestamp rentDate) {
        this.rentDate = rentDate;
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

    public BigDecimal getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(BigDecimal servicePrice) {
        this.servicePrice = servicePrice;
    }
}
