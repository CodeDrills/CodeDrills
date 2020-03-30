package com.codeon.controllers;

import com.codeon.models.ImageURL;
import com.codeon.models.Post;
import com.codeon.models.PostComment;
import com.codeon.models.User;
import com.codeon.repositories.*;
import com.codeon.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
public class InterviewQuestionController {

    private static Random randomStatic;
    private Random random = new Random();
    private PostRepo postDao;
    private UserRepo userDao;
    private PostTypeRepo postTypeDao;
    private PostCommentRepo postCommentDao;
    private ImageURLRepo imageURLDao;
    private EmailService emailService;

    public InterviewQuestionController(PostRepo postDao, UserRepo userDao, PostTypeRepo postTypeDao, PostCommentRepo postCommentDao, ImageURLRepo imageURLDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.postTypeDao = postTypeDao;
        this.postCommentDao = postCommentDao;
        this.imageURLDao = imageURLDao;
        this.emailService = emailService;
    }

    //SHOW IT JUST AS JSON.
    @GetMapping("/interview-question")
    @ResponseBody
    public List<Post> showInterviewQuestionsAsJSON() {
        return postDao.findAllByPostTypeId_Type("interview_question");
    }

    @GetMapping("/interview-question/show")
    public String showInterviewQuestions(Model model, Principal principal) {
        List<Post> interviewQuestions = postDao.findAllByPostTypeId_Type("interview_question");
        Post selectedPost = null;
        Integer pickQuestion, questionRoll, selectedPostRating;
        boolean determiningPost = true;
        while(determiningPost) {
            pickQuestion = random.nextInt(interviewQuestions.size());
            System.out.println("Selecting Question: " + pickQuestion);
            selectedPost = interviewQuestions.get(pickQuestion);
            selectedPostRating = selectedPost.getRatingTotal(selectedPost.getRatingList());
            System.out.println(selectedPostRating);
            questionRoll = random.nextInt(31) -10;
            if(selectedPostRating >= questionRoll) {
                determiningPost = false;
            }
        }
        String username = "";
        User user = new User();
        if (principal != null) {
            username = principal.getName();
            user = userDao.findUserByUsername(username);
        }
        model.addAttribute("user", user);
        model.addAttribute("post", selectedPost);
        return "/interview-questions/interview-question";
    }
}