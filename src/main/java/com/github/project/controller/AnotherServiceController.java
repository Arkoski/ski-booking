package com.github.project.controller;


import com.github.project.dto.AnotherServiceDTO;
import com.github.project.model.AnotherService;
import com.github.project.service.AnotherServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/another-service")
public class AnotherServiceController {

    private AnotherServiceService anotherServiceService;

    @Autowired
    public AnotherServiceController(AnotherServiceService anotherServiceService) {
        this.anotherServiceService = anotherServiceService;
    }


    @GetMapping("/{id}")
    public AnotherService findOneById(@PathVariable Long id) {
        return anotherServiceService.findById(id);
    }

    @PostMapping
    public AnotherService create(@RequestBody AnotherServiceDTO another) {
        return anotherServiceService.createAnotherService(another);
    }


    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        anotherServiceService.deleteAnotherService(id);
    }


    @GetMapping
    public Set<AnotherService> findAll() {

        Set<AnotherService> all = anotherServiceService.findAll();

        return new HashSet<>(all);
    }


}
