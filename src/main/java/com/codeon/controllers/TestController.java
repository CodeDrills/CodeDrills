package com.codeon.controllers;


import com.codeon.models.Post;
import com.codeon.models.User;
import com.codeon.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class TestController {

    @Value("${firebase.api.config}")
    private String firebaseKey;

    @Value("${talkjs.app.id}")
    private String talkJSAppId;

    private UserRepo userDao;

    public TestController(UserRepo userDao) {
        this.userDao = userDao;
    }
    //comment to make it where i can commit
    @GetMapping("/test/{otherUserId}")
    public String getTestHtml(Model model, Principal principal, @PathVariable Long otherUserId) {
        model.addAttribute("user", userDao.findUserByUsername(principal.getName()));
        model.addAttribute("otherUser", userDao.findUserById(otherUserId));
        model.addAttribute("talkJSAppId", talkJSAppId);
        return "talkjs/test";
    }
    @GetMapping("/test/user-select")
    public String showAllUsers(Model model, Principal principal) {
        model.addAttribute("user", userDao.findUserByUsername(principal.getName()));
        model.addAttribute("userList", userDao.findAll());
        return "talkjs/user-select";
    }
    @GetMapping("/test/whiteboard")
    public String getWhiteboard(Model model, Principal principal, @RequestParam(required = false) Long otherUserId) {
        model.addAttribute("user", userDao.findUserByUsername(principal.getName()));
        model.addAttribute("otherUser", userDao.findUserById(otherUserId));
        model.addAttribute("firebaseKey", firebaseKey);
        return "whiteboard/whiteboard";
    }
    @GetMapping("/test/ace")
    public String getAce(Model model, Principal principal, @RequestParam(required = false) Long otherUserId) {
        model.addAttribute("user", userDao.findUserByUsername(principal.getName()));
        model.addAttribute("otherUser", userDao.findUserById(otherUserId));
        return "whiteboard/ace";
    }
}
