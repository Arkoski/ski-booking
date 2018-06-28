package com.github.project.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;

    @OneToMany(mappedBy = "client")
    private Set<Order> orders;

    @OneToMany(mappedBy = "client")
    private Set<AnotherService> anotherServices;

    public Client() {
    }

    public Client(String name, String surname, Set<Order> orders, Set<AnotherService> anotherServices) {
        this.name = name;
        this.surname = surname;
        this.orders = orders;
        this.anotherServices = anotherServices;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<AnotherService> getAnotherServices() {
        return anotherServices;
    }

    public void setAnotherServices(Set<AnotherService> anotherServices) {
        this.anotherServices = anotherServices;
    }
}
