package com.github.project.service.implementation;

import com.github.project.dto.ClientDTO;
import com.github.project.exceptions.ValidationError;
import com.github.project.exceptions.ValidationException;
import com.github.project.model.Client;
import com.github.project.model.Role;
import com.github.project.repository.ClientRepository;
import com.github.project.repository.RoleRepository;
import com.github.project.service.ClientService;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.github.project.model.RoleEnum.NOT_VERIFIED;

@Service
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;
    private RoleRepository roleRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, RoleRepository roleRepository) {
        this.clientRepository = clientRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public Client findById(Long id) {
        Client client = clientRepository.findOne(id);
        validateFindById(client);
        return client;
    }

    @Override
    public Set<Client> findAll() {
        return new HashSet<>(clientRepository.findAll());
    }

    @Override
    public Client createClient(ClientDTO clientDTO) {
        validateCreation(clientDTO);

        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setSurname(clientDTO.getSurname());
        client.setPassword(clientDTO.getPassword());
        client.setEmail(clientDTO.getEmail());

        Role notVerified = roleRepository.findOneByName(NOT_VERIFIED.getName());
        client.setRole(notVerified);

        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        Client client = clientRepository.findOne(id);
        validateFindById(client);
        clientRepository.delete(id);
    }

    @Override
    public Client findByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    @Override
    public Client findByConfirmationToken(String confirmationToken) {
        return clientRepository.findByConfirmationToken(confirmationToken);
    }

    private void validateCreation(ClientDTO clientDTO) {
        String name = clientDTO.getName();
        String surname = clientDTO.getSurname();
        String password = clientDTO.getPassword();
        String email = clientDTO.getEmail();
        List<ValidationError> errors = new ArrayList<>();
        if (name == null) {
            ValidationError error = new ValidationError("name", "May not be null");
            errors.add(error);
        } else if (name.isEmpty()) {
            ValidationError error = new ValidationError("name", "May not be null");
            errors.add(error);
        }

        if (surname == null) {
            ValidationError error = new ValidationError("surname", "May not be null");
            errors.add(error);
        } else if (surname.isEmpty()) {
            ValidationError error = new ValidationError("surname", "May not be null");
            errors.add(error);
        }

        if (email == null) {
            ValidationError error = new ValidationError("email", "May not be null");
            errors.add(error);
        } else if (email.isEmpty()) {
            ValidationError error = new ValidationError("email", "May not be null");
            errors.add(error);
        } else if (!EmailValidator.getInstance().isValid(email)) {
            ValidationError error = new ValidationError("email", "Must be email format");
            errors.add(error);
        }


        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }

    private void validateFindById(Client client) {
        List<ValidationError> errors = new ArrayList<>();
        if (client == null) {
            ValidationError error = new ValidationError("id", "Wrong id");
            errors.add(error);
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }
}
