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
public class JobPostingsController {

    private Random random = new Random();
    private PostRepo postDao;
    private UserRepo userDao;
    private PostTypeRepo postTypeDao;
    private PostCommentRepo postCommentDao;
    private ImageURLRepo imageURLDao;
    private EmailService emailService;

    public JobPostingsController(PostRepo postDao, UserRepo userDao, PostTypeRepo postTypeDao, PostCommentRepo postCommentDao, ImageURLRepo imageURLDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.postTypeDao = postTypeDao;
        this.postCommentDao = postCommentDao;
        this.imageURLDao = imageURLDao;
        this.emailService = emailService;
    }

    //SHOW IT JUST AS JSON.
    @GetMapping("/job-postings")
    @ResponseBody
    public List<Post> showJobPostingsAsJSON() {
        return postDao.findAllByPostTypeId_Type("job-postings");
    }

    @GetMapping("/job-postings/show")
    public String showAllJobPostings(Model model, Principal principal) {
        List<Post> jobPostings = postDao.findAllByPostTypeId_Type("job-postings");
        String username = "";
        User user = new User();
        if(principal != null) {
            username = principal.getName();
            user = userDao.findUserByUsername(username);
        }
        model.addAttribute("user", user);
        model.addAttribute("postList", jobPostings);
        return "job-postings/show";
    }

    @GetMapping("/job-postings/create")
    public String jobPostingsCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "job-postings/create";
    }

    @PostMapping("/job-postings/create")
    public String createJobPosting(@RequestParam Long postTypeId, @ModelAttribute Post post) {
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
        return "redirect:/job-postings/show";
    }

    @GetMapping("/job-postings/{id}")
    public String getJobPostings(@PathVariable Long id, Model model, Principal principal){
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
        return "job-postings/show";
    }

    @GetMapping("/job-postings/edit/{id}")
    public String getEditJobPostingForm(@PathVariable Long id, Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post post = postDao.findPostById(id);
        if(user.getId() != post.getUser().getId()) {
            return "redirect:/job-postings/show";
        }
        model.addAttribute("post", post);
        return "job-postings/edit";
    }

    @PostMapping("/job-postings/edit/{id}")
    public String updateJobPosting(@PathVariable Long id, @ModelAttribute Post post) {
        Post dbPost = postDao.findPostById(id);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user.getId() != dbPost.getUser().getId()) {
            return "redirect:/job-postings/show";
        }
        dbPost.setTitle(post.getTitle());
        dbPost.setBody(post.getBody());
        dbPost.setAnswer(post.getEmployer());
        System.out.println("here");
        postDao.save(dbPost);
        return "redirect:/job-postings/show";
    }

    @DeleteMapping("/job-postings/delete")
    @ResponseBody
    public String deletePost(@RequestParam Long id, Model model, Principal principal){
        Post post = postDao.findPostById(id);
        User user = userDao.findUserByUsername(principal.getName());
        if(user.getId() != post.getUser().getId()) {
            return "-1";
        }
        postDao.deleteById(id);
        return "id";
    }
}