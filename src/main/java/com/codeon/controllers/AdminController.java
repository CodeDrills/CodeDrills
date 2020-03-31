package com.codeon.controllers;

import com.codeon.repositories.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    UserRepo userDao;

    public AdminController(UserRepo userDao) {
        this.userDao = userDao;
    }

    @GetMapping("admin/dashboard")
    public String getDashboard(Model model){

        model.addAttribute("adminList", userDao.findAllByRoleList_Role("ADMIN"));
        return "admin/dashboard";
    }
}
