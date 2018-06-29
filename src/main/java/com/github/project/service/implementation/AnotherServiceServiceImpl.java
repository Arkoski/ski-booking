package com.github.project.service.implementation;

import com.github.project.dto.AnotherServiceDTO;
import com.github.project.model.AnotherService;
import com.github.project.repository.AnotherServiceRepository;
import com.github.project.service.AnotherServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@Service
public class AnotherServiceServiceImpl implements AnotherServiceService{

    private AnotherServiceRepository anotherServiceRepository;

    @Autowired
    public AnotherServiceServiceImpl(AnotherServiceRepository anotherServiceRepository) {
        this.anotherServiceRepository = anotherServiceRepository;
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

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        AnotherService another = new AnotherService();
        another.setRentDate(LocalDateTime.now());
        another.setRentFrom(LocalDateTime.parse(anotherService.getRentFrom(), formatter));
        another.setRentTo(LocalDateTime.parse(anotherService.getRentTo(), formatter));
        another.setServicePrice(anotherService.getServiceType().getValue());
        another.setServicePaid(false);
        another.setServiceType(anotherService.getServiceType());
        another.setClient(anotherService.getClient());


        AnotherService save = anotherServiceRepository.save(another);

        return save;
    }

    @Override
    public void deleteAnotherService(Long id) {
        deleteAnotherService(id);
    }
}
