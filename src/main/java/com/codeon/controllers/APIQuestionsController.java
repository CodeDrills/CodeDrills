package com.codeon.controllers;

import com.codeon.models.Post;
import com.codeon.repositories.PostRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class APIQuestionsController {

    private PostRepo postDao;

    public APIQuestionsController(PostRepo postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/api/questions")
    public String getQuestionView() {
        return "questions/show";
    }
    @GetMapping("/api/questions/{id}")
    @ResponseBody
    public Post getQuestion(@PathVariable Long id) {
        return postDao.findPostById(id);
    }

}
