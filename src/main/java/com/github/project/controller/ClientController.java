package com.github.project.controller;

import com.github.project.dto.ClientDTO;
import com.github.project.model.Client;
import com.github.project.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/client")
public class ClientController {
    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{id}")
    public ClientDTO findOneById(@PathVariable Long id) {
        return new ClientDTO(clientService.findById(id));
    }

    @GetMapping
    public Set<ClientDTO> findAll() {
        Set<Client> all = clientService.findAll();
        return all.stream().map(client -> new ClientDTO(client)).collect(Collectors.toSet());
    }

    @PostMapping
    public ClientDTO createClient(@RequestBody ClientDTO clientDTO) {
        return new ClientDTO(clientService.createClient(clientDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

}
