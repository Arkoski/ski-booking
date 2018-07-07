package com.github.project.controller;

import com.github.project.dto.AnotherServiceDTO;
import com.github.project.model.AnotherService;
import com.github.project.service.AnotherServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/another-service")
public class AnotherServiceController {

    private AnotherServiceService anotherServiceService;

    @Autowired
    public AnotherServiceController(AnotherServiceService anotherServiceService) {
        this.anotherServiceService = anotherServiceService;
    }


    @GetMapping("/{id}")
    public AnotherServiceDTO findOneById(@PathVariable Long id) {
        return new AnotherServiceDTO(anotherServiceService.findById(id));
    }

    @PostMapping
    public AnotherServiceDTO create(@RequestBody AnotherServiceDTO another) {
        return new AnotherServiceDTO(anotherServiceService.createAnotherService(another));
    }


    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        anotherServiceService.deleteAnotherService(id);
    }


    @GetMapping
    public Set<AnotherServiceDTO> findAll() {
        Set<AnotherService> all = anotherServiceService.findAll();
        return all.stream().map(AnotherServiceDTO::new).collect(Collectors.toSet());
    }
}
