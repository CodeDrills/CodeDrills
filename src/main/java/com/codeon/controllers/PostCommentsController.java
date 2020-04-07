package com.codeon.controllers;

import com.codeon.models.Post;
import com.codeon.models.PostComment;
import com.codeon.models.PostCommentRating;
import com.codeon.models.User;
import com.codeon.repositories.*;
import com.codeon.services.EmailService;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class PostCommentsController {
    private PostRepo postDao;
    private UserRepo userDao;
    private PostTypeRepo postTypeDao;
    private PostCommentRepo postCommentDao;
    private ImageURLRepo imageURLDao;
    private EmailService emailService;
    private PostCommentRatingRepo postCommentRatingDao;

    public PostCommentsController(PostRepo postDao, PostCommentRatingRepo postCommentRatingDao, UserRepo userDao, PostTypeRepo postTypeDao, PostCommentRepo postCommentDao, ImageURLRepo imageURLDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.postTypeDao = postTypeDao;
        this.postCommentDao = postCommentDao;
        this.imageURLDao = imageURLDao;
        this.emailService = emailService;
        this.postCommentRatingDao = postCommentRatingDao;
    }


//    @GetMapping("/comments/create/{id}")
//    public String getPostCommentForm(@PathVariable Long id, Model model){
//        Post post = postDao.findPostById(id);
//        model.addAttribute("post", post);
//        model.addAttribute("postComment", new PostComment());
//        return "comments/create";
//    }
    @PostMapping("/comments/create/{id}")
    @ResponseBody
    public String createPostComment(@PathVariable Long id, @RequestParam String body, Principal principal) {
        Post post = postDao.findPostById(id);
        User user = userDao.findUserByUsername(principal.getName());
        PostComment postComment = new PostComment();
        postComment.setBody(body);
        postComment.setUser(user);
        postComment.setPost(post);
        Date now = new Date();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String date = formatter.format(now);
        postComment.setDateTime(date);
        postComment.setRatingTotal(0);
        postCommentDao.save(postComment);
        postCommentRatingDao.save(new PostCommentRating(postComment, user, 0));
        return String.format("%d", id);
    }

    @PostMapping("/comments/edit/{id}")
    public String updatePost(@PathVariable Long id, @RequestParam String body) {
        PostComment dbComment = postCommentDao.findPostCommentById(id);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user.getId() != dbComment.getUser().getId()) {
            return "-1";
        }
        System.out.println(body);
        dbComment.setBody(body);
        postCommentDao.save(dbComment);
        return "id";
    }
}
