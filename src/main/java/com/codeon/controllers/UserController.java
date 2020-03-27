package com.codeon.controllers;

import com.codeon.repositories.UserRepo;
import com.codeon.models.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UserRepo userDao;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepo userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user) {
        if ((userDao.findUserByUsername(user.getUsername()) == null)
            && (userDao.findUserByEmail(user.getEmail()) == null)) {
                String hash = passwordEncoder.encode(user.getPassword());
                user.setPassword(hash);
                userDao.save(user);
                return "redirect:/login";
            } else {
                return "redirect:/register";
            }
        }
    }