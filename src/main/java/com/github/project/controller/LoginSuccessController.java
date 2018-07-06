package com.github.project.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginSuccessController {
    @GetMapping("/loginSuccess")
    public String loginSuccess(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("username", username);

        if(SecurityContextHolder.getContext().getAuthentication().isAuthenticated()){
            model.addAttribute("auth", true);
        }else{
            model.addAttribute("auth", false);
        }

        return "loginSuccess";
    }
}
