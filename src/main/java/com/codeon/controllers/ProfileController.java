package com.codeon.controllers;


import com.codeon.models.Post;
import com.codeon.models.PostComment;
import com.codeon.models.PostType;
import com.codeon.models.User;
import com.codeon.repositories.PostCommentRepo;
import com.codeon.repositories.PostRepo;
import com.codeon.repositories.PostTypeRepo;
import com.codeon.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

//COMMENTED OUT SO I CAN RUN APP
@Controller
public class ProfileController {
    private UserRepo userDao;
    private PostRepo postDao;
    private PostCommentRepo postCommentDao;
    private PostTypeRepo postTypeDao;

//    @Value("${filestack.api.key}")
//    private String fsapi;

    public ProfileController(UserRepo userDao, PostRepo postDao, PostCommentRepo postCommentDao, PostTypeRepo postTypeDao){
        this.userDao= userDao;
        this.postDao= postDao;
        this.postCommentDao = postCommentDao;
        this.postTypeDao = postTypeDao;
    }



    @GetMapping("/profile")
    public String profileview(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Post> posts = postDao.getAllByUser_Id(user.getId());
        List<Post> interviewQuestions = postDao.findAllByPostTypeId_Type("interview_question");
        List<Post> mentorship = postDao.findAllByPostTypeId_Type("mentor_question");
        List<Post> jobPostings = postDao.findAllByPostTypeId_Type("job_listing");
        List<PostComment>  postComments = postCommentDao.getAllByUser_Id(user.getId());

        model.addAttribute("jobList", jobPostings);
        model.addAttribute("mentorList", mentorship);
        model.addAttribute("postList", interviewQuestions);
        model.addAttribute("postComment", postComments);
        model.addAttribute("post", posts);
        model.addAttribute("user", userDao.getOne((user.getId())));
//        model.addAttribute("fsapi", fsapi);
        return "users/profile";
    }
    @PostMapping("users/{id}/edit")
    public String profileEdit(@PathVariable long id, @ModelAttribute User user) {
        User updateInfo = userDao.getOne(id);
        updateInfo.setBio(user.getBio());
        userDao.save(updateInfo);
        return "redirect:/profile";
    }

}
