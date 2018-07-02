package com.github.project.service;

import com.github.project.dto.ClientDTO;
import com.github.project.model.Client;

import java.util.Set;

public interface ClientService {

    Client findById(Long id);
    Set<Client> findAll();
    Client createClient(ClientDTO client);
    void deleteClient(Long id);
    Client findByEmail(String email);
    Client findByConfirmationToken(String confirmationToken);
}
