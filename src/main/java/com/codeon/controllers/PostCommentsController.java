package com.codeon.controllers;

import com.codeon.models.Post;
import com.codeon.models.PostComment;
import com.codeon.models.User;
import com.codeon.repositories.*;
import com.codeon.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    public PostCommentsController(PostRepo postDao, UserRepo userDao, PostTypeRepo postTypeDao, PostCommentRepo postCommentDao, ImageURLRepo imageURLDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.postTypeDao = postTypeDao;
        this.postCommentDao = postCommentDao;
        this.imageURLDao = imageURLDao;
        this.emailService = emailService;
    }

    //Post Comments Controllers. Consider making sep controller. Consider removing the get method after testing and only use post.
    @GetMapping("/comments/create/{id}")
    public String getPostCommentForm(@PathVariable Long id, Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post post = postDao.findPostById(id);
        if(user.getId() != post.getUser().getId()) {
            return "redirect:/posts/show";
        }
        model.addAttribute("post", post);
        model.addAttribute("postComment", new PostComment());
        return "mentorship-posts/comments/create";
    }
    @PostMapping("/comments/create/{id}")
    public String createPostComment(@ModelAttribute Post post, @ModelAttribute PostComment postComment) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        postComment.setUser(user);
        postComment.setPost(post);
        Date now = new Date();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String date = formatter.format(now);
        postComment.setDateTime(date);
//        postComment.setRatingTotal(0);
        postCommentDao.save(postComment);
        return "redirect:/mentorship";
    }
}
