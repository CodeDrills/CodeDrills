package com.codeon.controllers;

import com.codeon.models.User;
import com.codeon.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


import java.security.Principal;

@Controller
public class ChatController {

    @Value("${talkjs.app.id}")
    private String talkJSAppId;

    private UserRepo userDao;


    public ChatController(UserRepo userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/chat/{otherUserId}")
    public String getTestHtml(Model model, Principal principal, @PathVariable Long otherUserId) {
        model.addAttribute("user", userDao.findUserByUsername(principal.getName()));
        model.addAttribute("otherUser", userDao.findUserById(otherUserId));
        model.addAttribute("talkJSAppId", talkJSAppId);
        return "chat/test-modal";
    }
    @GetMapping("/chat/inbox")
    public String getInbox(Model model, Principal principal, @RequestParam(required = false) Long with) {
        model.addAttribute("user", userDao.findUserByUsername(principal.getName()));
        User otherUser = with != null ? userDao.findUserById(with) : null;
        model.addAttribute("otherUser", otherUser);
        model.addAttribute("talkJSAppId", talkJSAppId);
        return "chat/inbox";
    }
    @GetMapping("/chat/user-select")
    public String showAllUsers(Model model, Principal principal) {
        model.addAttribute("user", userDao.findUserByUsername(principal.getName()));
        model.addAttribute("userList", userDao.findAll());
        return "chat/user-select";
    }

}
