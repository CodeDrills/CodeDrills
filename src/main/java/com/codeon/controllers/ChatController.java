package com.codeon.controllers;

import com.codeon.models.User;
import com.codeon.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

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
    @GetMapping("/chat/user-select")
    public String showAllUsers(Model model, Principal principal) {
        model.addAttribute("user", userDao.findUserByUsername(principal.getName()));
        model.addAttribute("userList", userDao.findAll());
        return "chat/user-select";
    }

    @GetMapping("/chat/inbox")
    public String getInbox(Model model, Principal principal) {
        model.addAttribute("user", userDao.findUserByUsername(principal.getName()));
        model.addAttribute("talkJSAppId", talkJSAppId);
        return "chat/inbox";
    }
    @GetMapping("/chat")
    @ResponseBody
    public List<User> getBothUsers(Principal principal, @RequestParam(required = false) String username, @RequestParam(required = false) Long id) {
        if (username != null && id == null) {
            List<User> outputList = new ArrayList<>(List.of(userDao.findUserByUsername(principal.getName())));
            outputList.addAll(userDao.findByUsernameContaining(username));
            return outputList;
        } else if (username == null && id != null) {
            return new ArrayList<>(List.of(userDao.findUserByUsername(principal.getName()), userDao.findUserById(id)));
        }
        return new ArrayList<>();
    }

}
