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


@Controller
public class MentorshipPostsController {

    @Value("${filestack.api.key}")
    private String filestackKey;
    @Value("${talkjs.app.id}")
    private String talkJSAppId;
    private PostRepo postDao;
    private UserRepo userDao;
    private PostTypeRepo postTypeDao;
    private ImageURLRepo imageURLDao;
    private PostRatingRepo postRatingDao;

    public MentorshipPostsController(PostRepo postDao, PostRatingRepo postRatingDao, UserRepo userDao, PostTypeRepo postTypeDao, ImageURLRepo imageURLDao) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.postTypeDao = postTypeDao;
        this.imageURLDao = imageURLDao;
        this.postRatingDao = postRatingDao;
    }

    @GetMapping("/mentorship")
    public String mentorshipHomeView(Model model, Principal principal) {
        model.addAttribute("user", userDao.findUserByUsername(principal.getName()));
        model.addAttribute("talkJSAppId", talkJSAppId);
        model.addAttribute("postList", postDao.findAllByPostTypeId_Type("mentorship-posts"));
        return "mentorship-posts/show";
    }
    @GetMapping("/mentorship-posts/show")
    public String showAllPosts(Model model, Principal principal) {
        model.addAttribute("filestackKey", filestackKey);
        model.addAttribute("user", userDao.findUserByUsername(principal.getName()));
        model.addAttribute("talkJSAppId", talkJSAppId);
        model.addAttribute("postList", postDao.findAllByPostTypeId_Type("mentorship-posts"));
        return "mentorship-posts/show";
    }
    @GetMapping("/mentorship-posts/create")
    public String getPostCreateForm(Model model, Principal principal) {
        model.addAttribute("user", userDao.findUserByUsername(principal.getName()));
        model.addAttribute("talkJSAppId", talkJSAppId);
        model.addAttribute("post", new Post());
        model.addAttribute("filestackKey", filestackKey);
        return "mentorship-posts/create";
    }
//    @PostMapping("/mentorship-posts/create")
//    public String createPost(Principal principal, @RequestParam String photoURL, @ModelAttribute Post post) {
//        User user = userDao.findUserByUsername(principal.getName());
//        post.setUser(user);
//        Date now = new Date();
//        String pattern = "yyyy-MM-dd";
//        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
//        String date = formatter.format(now);
//        post.setDateTime(date);
//        post.setRatingTotal(0);
//        post.setPostType(postTypeDao.getPostTypeById(2L));
//        post = postDao.save(post);
////        List<ImageURL> imageURLList = new ArrayList<>();
//        ImageURL imageURL = new ImageURL();
//        imageURL.setUrl(photoURL);
//        imageURL.setPost(post);
//        imageURL = imageURLDao.save(imageURL);
//        postRatingDao.save(new PostRating(post, user, 0));
////        imageURLList.add(imageURL);
////        post.setImageURLList(imageURLList);
//        return "redirect:/mentorship-posts/show";
//    }
    @PostMapping("/mentorship-posts/create")
    @ResponseBody
    public Post createPost(Principal principal, @RequestParam String title, @RequestParam String body, @RequestParam(required = false) String photoURL) {
        User user = userDao.findUserByUsername(principal.getName());
        Date now = new Date();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String date = formatter.format(now);
        Post post = new Post(title, null, body, null, user, postTypeDao.getPostTypeByType("mentorship-posts"), 0, date);
        if(!photoURL.equals("")) {
            ImageURL imageURL = new ImageURL();
            imageURL.setUrl(photoURL);
            imageURL.setPost(post);
            imageURLDao.save(imageURL);
        }
        post = postDao.save(post);
        postRatingDao.save(new PostRating(post, user, 0));
        return post;
    }
    @GetMapping("/mentorship-posts/{id}")
    public String getPost(@PathVariable Long id, Model model, Principal principal){
        List<Post> postList = new ArrayList<>();
        postList.add(postDao.getOne(id));
        model.addAttribute("user", userDao.findUserByUsername(principal.getName()));
        model.addAttribute("talkJSAppId", talkJSAppId);
        model.addAttribute("postList", postList);
        return "mentorship-posts/show";
    }

    @GetMapping("/mentorship-posts/edit/{id}")
    public String getEditPostForm(@PathVariable Long id, Model model, Principal principal){
        User user = userDao.findUserByUsername(principal.getName());
        Post post = postDao.findPostById(id);
        if(user.getId() != post.getUser().getId()) {
            return "redirect:/mentorship-posts/show";
        }
        model.addAttribute("user", user);
        model.addAttribute("talkJSAppId", talkJSAppId);
        model.addAttribute("post", post);
        return "mentorship-posts/edit";
    }

    @PostMapping("/mentorship-posts/edit/{id}")
    public String updatePost(@PathVariable Long id, @ModelAttribute Post post) {
        Post dbPost = postDao.findPostById(id);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user.getId() != dbPost.getUser().getId()) {
            return "redirect:/mentorship-posts/show";
        }
        dbPost.setTitle(post.getTitle());
        dbPost.setBody(post.getBody());
        postDao.save(dbPost);
        return "redirect:/mentorship-posts/show";
    }

    @DeleteMapping("/mentorship-posts/delete")
    @ResponseBody
    public String deletePost(@RequestParam Long id, Principal principal){
        Post post = postDao.findPostById(id);
        User user = userDao.findUserByUsername(principal.getName());
        if(user.getId() != post.getUser().getId()) {
            return "-1";
        }
        postDao.deleteById(id);
        return String.format("%d", id);
    }
}
