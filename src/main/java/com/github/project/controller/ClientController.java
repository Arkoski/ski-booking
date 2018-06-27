package com.github.project.controller;

import com.github.project.service.implementation.ClientServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {
    private ClientServiceImpl clientServiceImpl;

}
