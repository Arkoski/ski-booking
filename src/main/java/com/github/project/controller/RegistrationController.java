package com.github.project.controller;

import com.github.project.dto.ClientDTO;
import com.github.project.exceptions.ValidationException;
import com.github.project.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private ClientService clientService;


    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

//    @PostMapping(path = "/registration")
//    @ResponseBody
//    public ResponseEntity<ClientDTO> createClient(ClientDTO clientDTO) {
//        try {
//            return new ResponseEntity<>(new ClientDTO(clientService.createClient(clientDTO)), HttpStatus.CREATED);
//        } catch (ValidationException e) {
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("Location", "/registration-error");
//            return new ResponseEntity<>(headers, HttpStatus.FOUND);
//        }
//    }
    @PostMapping(path = "/registration")
    public String createClient(ClientDTO clientDTO, Model model) {
        try {
            ClientDTO created = new ClientDTO(clientService.createClient(clientDTO));
            return "login";
        } catch (ValidationException e) {
            model.addAttribute("error", true);
            model.addAttribute("errors", e.getErrors());
            return "registration";
        }
    }

    @GetMapping("/registration-error")
    public String loginError(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("error", true);
        return "registration";
    }

}