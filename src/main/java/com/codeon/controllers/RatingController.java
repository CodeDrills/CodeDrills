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
    private PostTypeRepo postTypeDao;
    private PostCommentRepo postCommentDao;

    public RatingController(PostRepo postDao, UserRepo userDao, PostTypeRepo postTypeDao, PostCommentRepo postCommentDao, ImageURLRepo imageURLDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.postTypeDao = postTypeDao;
        this.postCommentDao = postCommentDao;
    }

    @GetMapping("/posts/{id}/ratings/upvote")
    public String createPostRating(@PathVariable Long id) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post post = postDao.findPostById(id);
        List<PostRating> currentRatings = post.getRatingList();
        PostRating ratingToBeModified = new PostRating();
        for(PostRating rating : currentRatings) {
            rating.toString();
            if(rating.getUser().getId() == user.getId()) {
                ratingToBeModified = rating;
            }
        }
        ratingToBeModified.setPost(post);
        ratingToBeModified.setRating(1);
        post.setRatingTotal(post.getRatingList());
        return "redirect:/posts/show";
    }
}
