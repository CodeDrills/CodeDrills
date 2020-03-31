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
    @GetMapping("/interview-questions")
    @ResponseBody
    public List<Post> showInterviewQuestionsAsJSON() {
        return postDao.findAllByPostTypeId_Type("interview_question");
    }

    @GetMapping("/interview-questions/show")
    public String showAllInterviewQuestions(Model model, Principal principal) {
        List<Post> interviewQuestions = postDao.findAllByPostTypeId_Type("interview_question");
        String username = "";
        User user = new User();
        if(principal != null) {
            username = principal.getName();
            user = userDao.findUserByUsername(username);
        }
        model.addAttribute("user", user);
        model.addAttribute("postList", interviewQuestions);
        return "interview-questions/show";
    }

    @GetMapping("/interview-questions/show-one")
    public String showOneInterviewQuestion(Model model, Principal principal) {
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
        return "/interview-questions/show-one";
    }

    @GetMapping("/interview-questions/create")
    public String getPostCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "interview-questions/create";
    }

    @PostMapping("/interview-questions/create")
    public String createPost(@RequestParam Long postTypeId, @ModelAttribute Post post) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        Date now = new Date();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String date = formatter.format(now);
        post.setDateTime(date);
        post.setRatingTotal(0);
        post.setPostType(postTypeDao.getPostTypeById(postTypeId));
        postDao.save(post);
        return "redirect:/interview-questions/show";
    }
}