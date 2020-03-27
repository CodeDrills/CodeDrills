package com.codeon.controllers;

import com.codeon.repositories.UserRepo;
import com.codeon.models.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class UserController {
    private UserRepo userDao;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepo userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model, Principal principal) {
        //This prinicipal logic may be redundant or need to be deleted if spring security covers keeping logged in users away from this
        if(principal != null) {
            //which controller should this go to? profile?
            return "redirect:/profile";
        }
        model.addAttribute("user", new User());
        return "users/register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String photoURL, @RequestParam String resumeURL, @ModelAttribute User user, Principal principal) {
        //This prinicipal logic may be redundant or need to be deleted if spring security covers keeping logged in users away from this
        if(principal != null) {
            //which controller should this go to? profile?
            return "redirect:/profile";
        }
        if((userDao.findUserByUsername(user.getUsername()) != null) || (userDao.findUserByEmail(user.getEmail()) != null) || photoURL == null || resumeURL == null) {
            //THIS SHOULD BE REPLACED WITH SOME TYPE OF ERROR MESSAGE ABOVE FORM THAT TELLS THEM TO CHOOSE A DIFFERENT USERNAME OR EMAIL, etc
            return "redirect:/register";
        }
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        user.setProfileImageURL(photoURL);
        user.setResumeURL(resumeURL);
        userDao.save(user);
        return "redirect:/login";
    }
}