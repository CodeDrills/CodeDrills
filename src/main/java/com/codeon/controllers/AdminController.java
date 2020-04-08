package com.codeon.controllers;

import com.codeon.models.Post;
import com.codeon.models.User;
import com.codeon.repositories.PostRepo;
import com.codeon.repositories.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class AdminController {
    private UserRepo userDao;
    private PostRepo postDao;


    public AdminController(UserRepo userDao, PostRepo postDao) {
        this.userDao = userDao;
        this.postDao = postDao;
    }

    @GetMapping("admin/dashboard")
    public String getDashboard(Model model){
        model.addAttribute("userCount", userDao.findAll().size());
        model.addAttribute("deactivatedCount", userDao.findAllByIsActive(false).size());
        model.addAttribute("adminCount", userDao.findAllByRoleList_Role("ADMIN").size());
        model.addAttribute("instructorCount", userDao.findAllByRoleList_Role("INSTRUCTOR").size());
        model.addAttribute("alumnusCount", userDao.findAllByRoleList_Role("ALUMNUS").size());
        model.addAttribute("studentCount", userDao.findAllByRoleList_Role("STUDENT").size());
        return "admin/dashboard";
    }

    @GetMapping("/admin/posts/{id}")
    @ResponseBody
    public List<Post> getPostById(@PathVariable String postType, @PathVariable Long id) {
        List <Post> postList = new ArrayList<>();
        postList.add(postDao.findPostById(id));
        return postList;
    }

    @GetMapping("/admin/posts/{postType}")
    @ResponseBody
    public List<Post> getPostByType(@PathVariable String postType) {
        List <Post> postList;
        switch(postType) {
            case "interview-questions":
                postList = postDao.findAllByPostTypeId_Type("interview-questions");
                break;
            case "mentorship-posts":
                postList = postDao.findAllByPostTypeId_Type("mentorship-posts");
                break;
            case "job-postings":
                postList = postDao.findAllByPostTypeId_Type("job-postings");
                break;
            case "whiteboard-questions":
                postList = postDao.findAllByPostTypeId_Type("whiteboard-questions");
                break;
            default:
                postList = postDao.findAll();
                break;
        }
        postList.sort(Collections.reverseOrder(Comparator.comparing((Post::getId))));
        return postList;
    }

    @GetMapping("/admin/users/{userRole}")
    @ResponseBody
    public List<User> getUsersByRole(@PathVariable String userRole) {
        List <User> userList;
        switch(userRole) {
            case "admin":
                userList = userDao.findAllByRoleList_Role("ADMIN");
                break;
            case "instructor":
                userList = userDao.findAllByRoleList_Role("INSTRUCTOR");
                break;
            case "alumnus":
                userList = userDao.findAllByRoleList_Role("ALUMNUS");
                break;
            case "student":
                userList = userDao.findAllByRoleList_Role("STUDENT");
                break;
            case "deactivated":
                userList = userDao.findAllByIsActive(false);
                break;
            case "user":
                userList = userDao.findAll();
                break;
            default:
                userList = userDao.findAll();
                break;
        }
        userList.sort(Collections.reverseOrder(Comparator.comparing((User::getId))));
        return userList;
    }

    @GetMapping("/admin/users/skills")
    @ResponseBody
    public List<User> getUsersBySkill(@RequestParam List<String> skill) {
        List<User> userList = new ArrayList<>();
        for(String sk : skill) {
            userList.addAll(userDao.findAllBySkillList_Name(sk));
        }
        return userList;
    }

    @PostMapping("/admin/users/{action}")
    @ResponseBody
    public String modifyUserAccountStatus(@RequestParam Long id, @PathVariable String action){
        User user = userDao.findUserById(id);
        if(action.equals("deactivate")) {
            user.setActive(false);
        } else if (action.equals("activate")){
            user.setActive(true);
        }
        return String.format("{id: %d, status: %b}", id, user.isActive());
    }

    @DeleteMapping("/admin/posts/delete")
    @ResponseBody
    public String deletePost(@RequestParam Long id){
        postDao.deleteById(id);
        return String.format("{id: %d}", id);
    }

}
