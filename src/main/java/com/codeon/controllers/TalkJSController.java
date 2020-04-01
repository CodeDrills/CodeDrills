package com.codeon.controllers;


import com.codeon.models.Post;
import com.codeon.models.User;
import com.codeon.repositories.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class TalkJSController {
    private UserRepo userDao;

    public TalkJSController(UserRepo userDao) {
        this.userDao = userDao;
    }
    //comment to make it where i can commit
    @GetMapping("/test/{otherUserId}")
    public String getTestHtml(Model model, Principal principal, @PathVariable Long otherUserId) {
        String username;
        User user = new User();
        User otherUser = new User();
        if(principal != null) {
            username = principal.getName();
            user = userDao.findUserByUsername(username);
            otherUser = userDao.findUserById(otherUserId);
        }
        model.addAttribute("user", user);
        model.addAttribute("otherUser", otherUser);
        return "talkjs/test";
    }
    @GetMapping("/test/user-select")
    public String showAllPosts(Model model, Principal principal) {
        List<User> userList = userDao.findAll();
        String username;
        User user = new User();
        if(principal != null) {
            username = principal.getName();
            user = userDao.findUserByUsername(username);
        }
        model.addAttribute("user", user);
        model.addAttribute("userList", userList);
        return "talkjs/user-select";
    }
}
