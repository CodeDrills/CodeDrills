package com.codeon.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


//What is this? -Noland
    @Controller
    public class IndexController {

        @GetMapping("/")
        public String index(){

            return "index";

        }
}
