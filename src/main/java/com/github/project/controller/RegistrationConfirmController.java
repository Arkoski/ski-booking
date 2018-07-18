package com.github.project.controller;

import com.github.project.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationConfirmController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/registrationConfirm")
    public String loginError(@RequestParam("token")String token) {
        clientService.activateUser(token);
        return "registrationConfirm";
    }

}
