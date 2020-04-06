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
    private PostCommentRatingRepo postCommentRatingDao;

    public RatingController(PostRepo postDao, UserRepo userDao, PostRatingRepo postRatingDao, PostCommentRatingRepo postCommentRatingDao, PostTypeRepo postTypeDao, PostCommentRepo postCommentDao, ImageURLRepo imageURLDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.postRatingDao = postRatingDao;
        this.postTypeDao = postTypeDao;
        this.postCommentDao = postCommentDao;
        this.postCommentRatingDao = postCommentRatingDao;
    }

    /*If a user has already upvoted the post and they click upvote again it will set rating to 0
      If they have not rated the post yet, a new rating will be created and set to 1. */
    @PostMapping("/upvote/{id}")
    @ResponseBody
    public String upvote(@PathVariable Long id) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post post = postDao.findPostById(id);
        for(PostRating rating : post.getRatingList()) {
            if(rating.getUser().getId() == user.getId()) {
                if(rating.getRating() == 0 || rating.getRating() == -1) {
                    rating.setRating(1);
                } else {
                    rating.setRating(0);
                }
                postRatingDao.save(rating);
                post.setRatingTotal(post.getRatingList());
                return String.format("%d", post.getRatingTotal());
            }
        }
        PostRating newRating = new PostRating();
        newRating.setRating(1);
        newRating.setPost(post);
        newRating.setUser(user);
        postRatingDao.save(newRating);
        post.setRatingTotal(post.getRatingList());
        return String.format("%d", post.getRatingTotal());
    }

    /*If a user has already downvoted the post and they click downvote again it will set rating to 0
      If they have not rated the post yet, a new rating will be created and set to -1. */
    @PostMapping("/downvote/{id}")
    @ResponseBody
    public String downvote(@PathVariable Long id) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post post = postDao.findPostById(id);
        for(PostRating rating : post.getRatingList()) {
            if(rating.getUser().getId() == user.getId()) {
                if(rating.getRating() == 0 || rating.getRating() == 1) {
                    rating.setRating(-1);
                } else {
                    rating.setRating(0);
                }
                postRatingDao.save(rating);
                post.setRatingTotal(post.getRatingList());
                return String.format("%d", post.getRatingTotal());
            }
        }
        PostRating newRating = new PostRating();
        newRating.setRating(-1);
        newRating.setPost(post);
        newRating.setUser(user);
        postRatingDao.save(newRating);
        post.setRatingTotal(post.getRatingList());
        return String.format("%d", post.getRatingTotal());
    }

    @PostMapping("/upvote/comment/{id}")
    @ResponseBody
    public String commentUpvote(@PathVariable Long id) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        PostComment postComment = postCommentDao.findPostCommentById(id);
        for(PostCommentRating rating : postComment.getCommentRatingList()) {
            if(rating.getUser().getId() == user.getId()) {
                if(rating.getRating() == 0 || rating.getRating() == -1) {
                    rating.setRating(1);
                } else {
                    rating.setRating(0);
                }
                postCommentRatingDao.save(rating);
                postComment.setRatingTotal(postComment.getCommentRatingList());
                System.out.println(postComment.getRatingTotal());
                return String.format("%d", postComment.getRatingTotal());
            }
        }
        PostCommentRating newRating = new PostCommentRating();
        newRating.setRating(1);
        newRating.setPostComment(postComment);
        newRating.setUser(user);
        postCommentRatingDao.save(newRating);
        postComment.setRatingTotal(postComment.getCommentRatingList());
        System.out.println(postComment.getRatingTotal());
        return String.format("%d", postComment.getRatingTotal());
    }

    @PostMapping("/downvote/comment/{id}")
    @ResponseBody
    public String commentDownvote(@PathVariable Long id) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        PostComment postComment = postCommentDao.findPostCommentById(id);
        for(PostCommentRating rating : postComment.getCommentRatingList()) {
            if(rating.getUser().getId() == user.getId()) {
                if(rating.getRating() == 0 || rating.getRating() == 1) {
                    rating.setRating(-1);
                } else {
                    rating.setRating(0);
                }
                postCommentRatingDao.save(rating);
                postComment.setRatingTotal(postComment.getCommentRatingList());
                System.out.println(postComment.getRatingTotal());
                return String.format("%d", postComment.getRatingTotal());
            }
        }
        PostCommentRating newRating = new PostCommentRating();
        newRating.setRating(-1);
        newRating.setPostComment(postComment);
        newRating.setUser(user);
        postCommentRatingDao.save(newRating);
        postComment.setRatingTotal(postComment.getCommentRatingList());
        return String.format("%d", postComment.getRatingTotal());
    }
}
