package com.codeon.controllers;

import com.codeon.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TalkJSTestController {
    @GetMapping("/test")
    public String getTestHtml() {
        return "talkjs/test";
    }
}
