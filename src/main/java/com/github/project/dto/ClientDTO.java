package com.github.project.dto;

import com.github.project.model.Client;

public class ClientDTO {
    private String name;
    private String surname;
    private Long id;

    public ClientDTO() {
    }

    public ClientDTO(Client client) {
        this.name = client.getName();
        this.surname = client.getSurname();
        this.id = client.getId();
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
