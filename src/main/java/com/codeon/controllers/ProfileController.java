package com.codeon.controllers;


import com.codeon.models.Post;
import com.codeon.models.User;
import com.codeon.repositories.PostRepo;
import com.codeon.repositories.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProfileController {
    private UserRepo userDao;
    private PostRepo postDao;


    public ProfileController(UserRepo userDao, PostRepo postDao){
        this.userDao= userDao;
        this.postDao= postDao;
    }



    @GetMapping("/profile")
    public String profileview(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", userDao.getOne((user.getId())));
        return"users/profile";
    }


}
