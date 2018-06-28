package com.github.project.service;

import com.github.project.dto.AnotherServiceDTO;
import com.github.project.dto.OrdersDTO;
import com.github.project.model.AnotherService;
import com.github.project.model.Orders;

import java.util.Set;

public interface AnotherServiceService {

    AnotherService findById(Long id);
    Set<AnotherService> findAll();
    AnotherService createAnotherService(AnotherServiceDTO anotherService);
    void deleteAnotherService(Long id);

}
