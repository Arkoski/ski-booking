package com.github.project.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @NotEmpty(message = "Please provide your first name")
    private String name;

    @Column(name = "last_name")
    @NotEmpty(message = "Please provide your last name")
    private String surname;

    @Column(name = "email", nullable = false, unique = true)
    @Email(message = "Please provide a valid e-mail")
    @NotEmpty(message = "Please provide an e-mail")
    private String email;

    @Column(name = "password")
    @Transient
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "confirmation_token")
    private String confirmationToken;


    @OneToMany(mappedBy = "client")
    private Set<Order> orders;

    @OneToMany(mappedBy = "client")
    private Set<AnotherService> anotherServices;

    public Client() {
    }

    public Client(String name, String surname, String email, String password, boolean enabled, String confirmationToken, Set<Order> orders, Set<AnotherService> anotherServices) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.confirmationToken = confirmationToken;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }
}
