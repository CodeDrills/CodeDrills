package com.codeon.controllers;

import com.codeon.repositories.PostRepo;
import com.codeon.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class WhiteboardController {
    @Value("${filestack.api.key}")
    private String filestackKey;
    @Value("${firebase.api.config}")
    private String firebaseKey;
    @Value("${talkjs.app.id}")
    private String talkJSAppId;
    private UserRepo userDao;
    private PostRepo postDao;

    public WhiteboardController(UserRepo userDao, PostRepo postDao) {
        this.userDao = userDao;
        this.postDao = postDao;
    }

    @GetMapping("/whiteboard")
    public String getWhiteboard(Model model, Principal principal, @RequestParam(required = false) Long otherUserId) {
        model.addAttribute("filestackKey", filestackKey);
        model.addAttribute("user", userDao.findUserByUsername(principal.getName()));
        model.addAttribute("talkJSAppId", talkJSAppId);
        model.addAttribute("otherUser", userDao.findUserById(otherUserId));
        model.addAttribute("questionsList", postDao.findAllByPostTypeId_Type("interview-questions"));
        model.addAttribute("firebaseKey", firebaseKey);
        return "whiteboard/whiteboard";
    }
    @GetMapping("/whiteboard/1")
    public String getRoomOne(Model model, Principal principal, @RequestParam(required = false) Long otherUserId) {
        model.addAttribute("filestackKey", filestackKey);
        model.addAttribute("user", userDao.findUserByUsername(principal.getName()));
        model.addAttribute("talkJSAppId", talkJSAppId);
        model.addAttribute("otherUser", userDao.findUserById(otherUserId));
        model.addAttribute("questionsList", postDao.findAllByPostTypeId_Type("whiteboard-questions"));
        model.addAttribute("firebaseKey", firebaseKey);
        return "redirect:/whiteboard#-M40Al3zn-5wmh_f_lkj";
    }
    @GetMapping("/whiteboard/2")
    public String getRoomTwo(Model model, Principal principal, @RequestParam(required = false) Long otherUserId) {
        model.addAttribute("filestackKey", filestackKey);
        model.addAttribute("user", userDao.findUserByUsername(principal.getName()));
        model.addAttribute("talkJSAppId", talkJSAppId);
        model.addAttribute("otherUser", userDao.findUserById(otherUserId));
        model.addAttribute("questionsList", postDao.findAllByPostTypeId_Type("whiteboard-questions"));
        model.addAttribute("firebaseKey", firebaseKey);
        return "redirect:/whiteboard#-M40BUW1hibtddE4IqWj";
    }
    @GetMapping("/whiteboard/3")
    public String getRoomThree(Model model, Principal principal, @RequestParam(required = false) Long otherUserId) {
        model.addAttribute("filestackKey", filestackKey);
        model.addAttribute("user", userDao.findUserByUsername(principal.getName()));
        model.addAttribute("talkJSAppId", talkJSAppId);
        model.addAttribute("otherUser", userDao.findUserById(otherUserId));
        model.addAttribute("questionsList", postDao.findAllByPostTypeId_Type("whiteboard-questions"));
        model.addAttribute("firebaseKey", firebaseKey);
        return "redirect:/whiteboard#-M40BsnppLXBgzKJOdOl";
    }
    @GetMapping("/whiteboard/4")
    public String getRoomFour(Model model, Principal principal, @RequestParam(required = false) Long otherUserId) {
        model.addAttribute("filestackKey", filestackKey);
        model.addAttribute("user", userDao.findUserByUsername(principal.getName()));
        model.addAttribute("talkJSAppId", talkJSAppId);
        model.addAttribute("otherUser", userDao.findUserById(otherUserId));
        model.addAttribute("questionsList", postDao.findAllByPostTypeId_Type("whiteboard-questions"));
        model.addAttribute("firebaseKey", firebaseKey);
        return "redirect:/whiteboard#-M4FMmqvgFrQy9fJzYTj";
    }
}
