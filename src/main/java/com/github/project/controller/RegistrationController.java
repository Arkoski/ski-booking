package com.github.project.controller;

import com.github.project.dto.ClientDTO;
import com.github.project.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private ClientService clientService;


    @GetMapping("/registration")
    public String registration() {



//        model.addAttribute("firstname", firstname);
//        model.addAttribute("lastname", lastname);
//        model.addAttribute("password", password);
//        model.addAttribute("email", email);

        return "registration";
    }

    @PostMapping(path = "/registration")
    public ClientDTO createClient(ClientDTO clientDTO) {
        return new ClientDTO(clientService.createClient(clientDTO));
    }

}