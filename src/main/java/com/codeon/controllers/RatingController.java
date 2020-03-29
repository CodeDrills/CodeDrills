package com.codeon.controllers;

import com.codeon.models.*;
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

@Controller
public class RatingController {

    private PostRepo postDao;
    private UserRepo userDao;
    private PostRatingRepo postRatingDao;
    private PostTypeRepo postTypeDao;
    private PostCommentRepo postCommentDao;

    public RatingController(PostRepo postDao, UserRepo userDao, PostRatingRepo postRatingDao, PostTypeRepo postTypeDao, PostCommentRepo postCommentDao, ImageURLRepo imageURLDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.postRatingDao = postRatingDao;
        this.postTypeDao = postTypeDao;
        this.postCommentDao = postCommentDao;
    }

    @GetMapping("/posts/{id}/ratings/upvote")
    public String createUpvote(@PathVariable Long id, Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post post = postDao.findPostById(id);
        for(PostRating rating : post.getRatingList()) {
            if(rating.getUser().getId() == user.getId()) {
                rating.setRating(1);
                postRatingDao.save(rating);
                post.setRatingTotal(post.getRatingList());
                return "redirect:/posts/show";
            }
        }
        PostRating newRating = new PostRating();
        newRating.setRating(1);
        newRating.setPost(post);
        newRating.setUser(user);
        postRatingDao.save(newRating);
        post.setRatingTotal(post.getRatingList());
        return "redirect:/posts/show";
    }

    @GetMapping("/posts/{id}/ratings/downvote")
    public String createDownvote(@PathVariable Long id) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post post = postDao.findPostById(id);
        for(PostRating rating : post.getRatingList()) {
            if(rating.getUser().getId() == user.getId()) {
                rating.setRating(-1);
                postRatingDao.save(rating);
                post.setRatingTotal(post.getRatingList());
                return "redirect:/posts/show";
            }
        }
        PostRating newRating = new PostRating();
        newRating.setRating(-1);
        newRating.setPost(post);
        newRating.setUser(user);
        postRatingDao.save(newRating);
        post.setRatingTotal(post.getRatingList());
        return "redirect:/posts/show";
    }
}
