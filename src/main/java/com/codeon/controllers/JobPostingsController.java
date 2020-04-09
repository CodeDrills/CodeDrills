package com.codeon.controllers;

import com.codeon.models.*;
import com.codeon.repositories.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class JobPostingsController {

    @Value("${filestack.api.key}")
    private String filestackKey;
    private PostRepo postDao;
    private UserRepo userDao;
    private PostTypeRepo postTypeDao;
    private PostRatingRepo postRatingDao;

    public JobPostingsController(PostRepo postDao, PostRatingRepo postRatingDao, UserRepo userDao, PostTypeRepo postTypeDao) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.postTypeDao = postTypeDao;
        this.postRatingDao = postRatingDao;
    }

    //SHOW IT JUST AS JSON.
    @GetMapping("/job-postings")
    @ResponseBody
    public List<Post> showJobPostingsAsJSON() {
        return postDao.findAllByPostTypeId_Type("job-postings");
    }

    @GetMapping("/job-postings/show")
    public String showAllJobPostings(Model model, Principal principal) {
        model.addAttribute("user", userDao.findUserByUsername(principal.getName()));
        model.addAttribute("postList", postDao.findAllByPostTypeId_Type("job-postings"));
        return "job-postings/show";
    }

    @GetMapping("/job-postings/create")
    public String jobPostingsCreateForm(Model model, Principal principal) {
        model.addAttribute("user", userDao.findUserByUsername(principal.getName()));
        model.addAttribute("post", new Post());
        model.addAttribute("filestackKey", filestackKey);
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
        postRatingDao.save(new PostRating(post, user, 0));
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
    public String deletePost(@RequestParam Long id, Principal principal){
        Post post = postDao.findPostById(id);
        User user = userDao.findUserByUsername(principal.getName());
        if(user.getId() != post.getUser().getId()) {
            return "-1";
        }
        postDao.deleteById(id);
        return String.format("&d", id);
    }
}