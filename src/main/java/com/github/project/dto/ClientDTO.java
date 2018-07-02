package com.github.project.dto;

import com.github.project.model.Client;

public class ClientDTO {
    private String name;
    private String surname;
    private String email;
    private String password;


    public ClientDTO() {
    }

    public ClientDTO(Client client) {
        this.name = client.getName();
        this.surname = client.getSurname();
        this.password = client.getPassword();
        this.email = client.getEmail();

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
}
