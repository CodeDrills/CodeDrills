package com.codeon.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
// created for the splash page so users can see the home page only without logging in
    @GetMapping("/")
    public String index(){

        return "index";

    }

}