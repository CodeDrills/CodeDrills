package com.codeon.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class AuthenticationController {
    @GetMapping("/login")
    public String showLoginForm(Principal principal) {
        if(principal != null) {
            return "redirect:/users/dashboard";
        }
        return "users/login";
    }
}
