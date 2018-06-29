package com.github.project.service.implementation;

import com.github.project.dto.AnotherServiceDTO;
import com.github.project.exceptions.ValidationError;
import com.github.project.exceptions.ValidationException;
import com.github.project.model.AnotherService;
import com.github.project.repository.AnotherServiceRepository;
import com.github.project.repository.ClientRepository;
import com.github.project.service.AnotherServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AnotherServiceServiceImpl implements AnotherServiceService{

    private AnotherServiceRepository anotherServiceRepository;
    private ClientRepository clientRepository;

    @Autowired
    public AnotherServiceServiceImpl(AnotherServiceRepository anotherServiceRepository, ClientRepository clientRepository) {
        this.anotherServiceRepository = anotherServiceRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public AnotherService findById(Long id) {
        return anotherServiceRepository.findOne(id);
    }

    @Override
    public Set<AnotherService> findAll() {
        return new HashSet<>(anotherServiceRepository.findAll());
    }

    @Override
    public AnotherService createAnotherService(AnotherServiceDTO anotherService) {

        validateCreation(anotherService.getRentFrom(),anotherService.getRentTo(),anotherService.getClientId());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        AnotherService another = new AnotherService();
        another.setRentDate(LocalDateTime.now());
        another.setRentFrom(LocalDateTime.parse(anotherService.getRentFrom(), formatter));
        another.setRentTo(LocalDateTime.parse(anotherService.getRentTo(), formatter));
        another.setServicePrice(anotherService.getServiceType().getValue());
        another.setServicePaid(false);
        another.setServiceType(anotherService.getServiceType());
        another.setClient(clientRepository.findOne(anotherService.getClientId()));


        AnotherService save = anotherServiceRepository.save(another);

        return save;
    }

    @Override
    public void deleteAnotherService(Long id) {
        deleteAnotherService(id);
    }

    private void validateCreation(String rentFrom, String rentTo, Long id) {
        List<ValidationError> errors = new ArrayList<>();
        if (rentFrom == null) {
            ValidationError error = new ValidationError("rentFrom", "May not be null");
            errors.add(error);
        } else if (rentFrom.isEmpty()) {
            ValidationError error = new ValidationError("rentFrom", "May not be null");
            errors.add(error);
        }

        if (rentTo == null) {
            ValidationError error = new ValidationError("rentTo", "May not be null");
            errors.add(error);
        } else if (rentTo.isEmpty()) {
            ValidationError error = new ValidationError("rentTo", "May not be null");
            errors.add(error);
        }

        if (id == null) {
            ValidationError error = new ValidationError("id", "May not be null");
            errors.add(error);
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }

    private void validateFindById(AnotherService anotherService) {
        List<ValidationError> errors = new ArrayList<>();
        if (anotherService == null) {
            ValidationError error = new ValidationError("id", "Wrong id");
            errors.add(error);
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }
}
