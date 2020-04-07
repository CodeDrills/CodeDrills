package com.codeon.controllers;

import com.codeon.models.Post;
import com.codeon.models.PostComment;
import com.codeon.models.PostCommentRating;
import com.codeon.models.User;
import com.codeon.repositories.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class PostCommentsController {
    private PostRepo postDao;
    private UserRepo userDao;
    private PostCommentRepo postCommentDao;
    private PostCommentRatingRepo postCommentRatingDao;

    public PostCommentsController(PostRepo postDao, UserRepo userDao, PostCommentRepo postCommentDao, PostCommentRatingRepo postCommentRatingDao) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.postCommentDao = postCommentDao;
        this.postCommentRatingDao = postCommentRatingDao;
    }

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
    @ResponseBody
    public String updatePost(@PathVariable Long id, @RequestParam String body, Principal principal) {
        PostComment dbComment = postCommentDao.findPostCommentById(id);
        User user = userDao.findUserByUsername(principal.getName());
        if(user.getId() != dbComment.getUser().getId()) {
            return "-1";
        }
        dbComment.setBody(body);
        postCommentDao.save(dbComment);
        return String.format("&d", id);
    }
}
