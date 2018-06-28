package com.github.project.controller;

import com.github.project.dto.ClientDTO;
import com.github.project.model.Client;
import com.github.project.service.ClientService;
import com.github.project.service.implementation.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/client")
public class ClientController {
    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{id}")
    public Client findOneById(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @GetMapping
    public Set<Client> findAll() {
        Set<Client> all = clientService.findAll();
        return new HashSet<>(all);
    }

    @PostMapping
    public Client createClient(@RequestBody ClientDTO clientDTO) {
        return clientService.createClient(clientDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

}
