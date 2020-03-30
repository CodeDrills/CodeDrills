package com.codeon.controllers;


import com.codeon.models.Post;
import com.codeon.models.User;
import com.codeon.repositories.PostRepo;
import com.codeon.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

//COMMENTED OUT SO I CAN RUN APP
//@Controller
public class ProfileController {
//    private UserRepo userDao;
//    private PostRepo postDao;
//
//    @Value("${filestack.api.key}")
//    private String fsapi;
//
//    public ProfileController(UserRepo userDao, PostRepo postDao){
//        this.userDao= userDao;
//        this.postDao= postDao;
//    }
//
//
//
//    @GetMapping("/profile")
//    public String profileview(Model model){
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        List<Post> posts = postDao.getAllByUser_Id(user.getId());
//        model.addAttribute("post", posts);
//        model.addAttribute("user", userDao.getOne((user.getId())));
//        model.addAttribute("fsapi", fsapi);
//        return "users/profile";
//    }
//
//
//
//
}
