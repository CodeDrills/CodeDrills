package com.codeon.controllers;

import com.codeon.models.ImageURL;
import com.codeon.models.Post;
import com.codeon.models.User;
import com.codeon.repositories.ImageURLRepo;
import com.codeon.repositories.PostRepo;
import com.codeon.repositories.PostTypeRepo;
import com.codeon.repositories.UserRepo;
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

@Controller
public class PostController {

    private PostRepo postDao;
    private UserRepo userDao;
    private PostTypeRepo postTypeDao;
    private ImageURLRepo imageURLDao;
    private EmailService emailService;

    public PostController(PostRepo postDao, UserRepo userDao, PostTypeRepo postTypeDao, ImageURLRepo imageURLDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.postTypeDao = postTypeDao;
        this.imageURLDao = imageURLDao;
        this.emailService = emailService;
    }

    //SHOW IT JUST AS JSON.
    @GetMapping("/posts")
    @ResponseBody
    public List<Post> getAllPosts() {
        return postDao.findAll();
    }

    @GetMapping("/posts/show")
    public String showAllPosts(Model model, Principal principal) {
        List<Post> postList = postDao.findAll();
        String username = "";
        User user = new User();
        if(principal != null) {
            username = principal.getName();
            user = userDao.findUserByUsername(username);
        }
        model.addAttribute("user", user);
        model.addAttribute("postList", postList);
        return "posts/show";
    }
    @GetMapping("/posts/create")
    public String getPostCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }
    @PostMapping("/posts/create")
    public String createPost(@RequestParam Long postTypeId, @RequestParam String photoURL, @ModelAttribute Post post) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        Date now = new Date();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String date = formatter.format(now);
        //HERE WE SET THE DATE OF THE POST
        Post continuePost = (Post) postDao.save(post);
        ImageURL imageURL = new ImageURL();
        imageURL.setUrl(photoURL);
        imageURL.setPost(continuePost);
        post.setPostType(postTypeDao.getPostTypeById(postTypeId));
        postDao.save(post);
//        String emailSubject = "A post on the blog was made by " + post.getUser().getUsername() + "." + " It is titled " + post.getTitle() + ".";
//        String emailBody = "The post on the blog was " + post.getBody();
//        emailService.prepareAndSend(post, emailSubject, emailBody);
        return "redirect:/posts/show";
    }
    @GetMapping("/posts/{id}")
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
        return "posts/show";
    }

    @GetMapping("/posts/{id}/edit")
    public String getEditPostForm(@PathVariable Long id, Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post post = postDao.findPostById(id);
        if(user.getId() != post.getUser().getId()) {
            return "redirect:/posts/show";
        }
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost(@PathVariable Long id, @ModelAttribute Post post) {
        Post dbPost = postDao.findPostById(id);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user.getId() != dbPost.getUser().getId()) {
            return "redirect:/posts/show";
        }
        dbPost.setTitle(post.getTitle());
        dbPost.setEmployer(post.getEmployer());
        dbPost.setBody(post.getBody());
        dbPost.setPostType(post.getPostType());
        dbPost.setImageURLList(post.getImageURLList());
        dbPost.setCommentList(post.getCommentList());
        dbPost.setRatingList(post.getRatingList());
        dbPost.setRatingTotal(post.getRatingList());
        dbPost.setCreated(post.getCreated());
        postDao.save(dbPost);
        return "redirect:/posts/show";
    }

    @DeleteMapping("/posts/delete")
    public String deletePost(@RequestParam Long id, Model model){
        Post post = postDao.findPostById(id);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user.getId() != post.getUser().getId()) {
            return "redirect:/posts/show";
        }
        String deletedTitle = post.getTitle();
        postDao.deleteById(id);
        //Update this to display things if needed.
        model.addAttribute("title", "Deleted");
        model.addAttribute("body", deletedTitle);
        return "redirect:/posts/show";
    }
}
