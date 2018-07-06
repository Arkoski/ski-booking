package com.github.project.controller;

import com.github.project.security.ClientUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(Model model) {
//        String username = SecurityContextHolder.getContext().getAuthentication().getName();
//        model.addAttribute("username", username);
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
//        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        ClientUserDetails clientUserDetails = (ClientUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (clientUserDetails.isEnabled()){
            model.addAttribute("auth", true);
        }
        model.addAttribute("error", true);
        return "login";
    }

//    @GetMapping("/login-authenticate")
//    public String loginAuthenticate(Model model) {
//        String username = SecurityContextHolder.getContext().getAuthentication().getName();
//        model.addAttribute("auth", true);
//        return "login";
//    }

}


