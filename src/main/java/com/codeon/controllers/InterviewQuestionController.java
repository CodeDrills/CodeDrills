package com.codeon.controllers;

import com.codeon.models.*;
import com.codeon.repositories.*;
import com.codeon.services.EmailService;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${filestack.api.key}")
    private String filestackKey;
    private Random random = new Random();
    private PostRepo postDao;
    private UserRepo userDao;
    private PostTypeRepo postTypeDao;
    private PostRatingRepo postRatingDao;

    public InterviewQuestionController(PostRepo postDao, PostRatingRepo postRatingDao, UserRepo userDao, PostTypeRepo postTypeDao) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.postTypeDao = postTypeDao;
        this.postRatingDao = postRatingDao;
    }

    //SHOW IT JUST AS JSON.
    @GetMapping("/interview-questions")
    @ResponseBody
    public List<Post> showInterviewQuestionsAsJSON() {
        return postDao.findAllByPostTypeId_Type("interview-questions");
    }

    @GetMapping("/interview-questions/show")
    public String showAllInterviewQuestions(Model model, Principal principal) {
        model.addAttribute("user", userDao.findUserByUsername(principal.getName()));
        model.addAttribute("postList", postDao.findAllByPostTypeId_Type("interview-questions"));
        return "interview-questions/show";
    }

    @GetMapping("/interview-questions/show-one")
    public String showOneInterviewQuestion(Model model, Principal principal) {
        List<Post> interviewQuestions = postDao.findAllByPostTypeId_Type("interview-questions");
        Post selectedPost = null;
        Integer pickQuestion, questionRoll, selectedPostRating;
        boolean determiningPost = true;
        while(determiningPost) {
            pickQuestion = random.nextInt(interviewQuestions.size());
            selectedPost = interviewQuestions.get(pickQuestion);
            selectedPostRating = selectedPost.getRatingTotal(selectedPost.getRatingList());
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
        model.addAttribute("filestackKey", filestackKey);
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
        postRatingDao.save(new PostRating(post, user, 0));
        return "redirect:/interview-questions/show";
    }

    @GetMapping("/interview-questions/{id}")
    public String getPost(@PathVariable Long id, Model model, Principal principal){
        String username;
        User user = new User();
        List<Post> postList = new ArrayList<>();
        postList.add(postDao.getOne(id));
        if(principal != null) {
            username = principal.getName();
            user = userDao.findUserByUsername(username);
        }
        model.addAttribute("user", user);
        model.addAttribute("postList", postList);
        return "interview-questions/show";
    }

    @GetMapping("/interview-questions/edit/{id}")
    public String getEditPostForm(@PathVariable Long id, Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post post = postDao.findPostById(id);
        if(user.getId() != post.getUser().getId()) {
            return "redirect:/interview-questions/show";
        }
        model.addAttribute("post", post);
        return "interview-questions/edit";
    }

    @PostMapping("/interview-questions/edit/{id}")
    public String updatePost(@PathVariable Long id, @ModelAttribute Post post) {
        Post dbPost = postDao.findPostById(id);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user.getId() != dbPost.getUser().getId()) {
            return "redirect:/interview-questions/show";
        }
        dbPost.setTitle(post.getTitle());
        dbPost.setBody(post.getBody());
        dbPost.setAnswer(post.getAnswer());
        postDao.save(dbPost);
        return "redirect:/interview-questions/show";
    }

    @DeleteMapping("/interview-questions/delete")
    @ResponseBody
    public String deletePost(@RequestParam Long id, Model model, Principal principal){
        Post post = postDao.findPostById(id);
        User user = userDao.findUserByUsername(principal.getName());
        if(user.getId() != post.getUser().getId()) {
            return "-1";
        }
        postDao.deleteById(id);
        return String.format("%d", id);
    }
}