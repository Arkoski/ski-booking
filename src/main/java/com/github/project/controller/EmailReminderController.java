package com.github.project.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmailReminderController {
    @GetMapping("/emailReminder")
    public String login() {
        SecurityContextHolder.clearContext();
        return "emailReminder";
    }
}
