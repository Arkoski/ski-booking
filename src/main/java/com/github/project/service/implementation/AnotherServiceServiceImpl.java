package com.github.project.service.implementation;

import com.github.project.dto.AnotherServiceDTO;
import com.github.project.model.AnotherService;
import com.github.project.repository.AnotherServiceRepository;
import com.github.project.service.AnotherServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        AnotherService another = new AnotherService();
        another.setRentDate(anotherService.getRentDate());
        another.setRentFrom(anotherService.getRentFrom());
        another.setRentTo(anotherService.getRentTo());
        another.setServicePrice(anotherService.getServicePrice());
        another.setServicePaid(anotherService.isServicePaid());

        AnotherService save = anotherServiceRepository.save(another);

        return save;
    }

    @Override
    public void deleteAnotherService(Long id) {
        deleteAnotherService(id);
    }
}
