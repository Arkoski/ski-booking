package com.github.project.controller;

import com.github.project.dto.ClientDTO;
import com.github.project.exceptions.ValidationException;
import com.github.project.model.Client;
import com.github.project.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private MailSender mailSender;

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
            Client client = clientService.createClient(clientDTO);
//            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            confirmRegistration(new ClientDTO(client), client.getConfirmationToken());
            return "login";
        } catch (ValidationException e) {
            model.addAttribute("error", true);
            model.addAttribute("errors", e.getErrors());
            return "registration";
        }
    }

    @GetMapping("/registration-error")
    public String loginError(Model model) {
//        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("error", true);
        return "registration";
    }

    private void confirmRegistration(ClientDTO clientDTO, String token) {


        String recipientAddress = clientDTO.getEmail();
        String subject = "Registration Confirmation";
        String confirmationUrl = "/registrationConfirm?token=" + token;

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText("http://localhost:8080" + confirmationUrl);
        mailSender.send(email);
    }


}