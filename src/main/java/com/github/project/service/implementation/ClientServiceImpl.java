package com.github.project.service.implementation;


import com.github.project.dto.ClientDTO;
import com.github.project.model.Client;
import com.github.project.repository.ClientRepository;
import com.github.project.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findOne(id);
    }

    @Override
    public Set<Client> findAll() {
        return new HashSet<>(clientRepository.findAll());
    }

    @Override
    public Client createClient(ClientDTO clientDTO) {
        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setSurname(clientDTO.getSurname());

        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
            clientRepository.delete(id);
    }
}
