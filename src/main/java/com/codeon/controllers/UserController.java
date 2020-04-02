package com.codeon.controllers;

import com.codeon.models.*;
import com.codeon.repositories.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class UserController {
    private UserRepo userDao;
    private PasswordEncoder passwordEncoder;
    private SecurityRoleRepo securityRoleDao;
    private SkillRepo skillDao;
    private PostRepo postDao;
    private PostCommentRepo postCommentDao;
    private PostTypeRepo postTypeDao;

    public UserController(UserRepo userDao, PasswordEncoder passwordEncoder, SecurityRoleRepo securityRoleDao, SkillRepo skillDao, PostRepo postDao, PostCommentRepo postCommentDao, PostTypeRepo postTypeDao) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.securityRoleDao = securityRoleDao;
        this.skillDao = skillDao;
        this.postDao = postDao;
        this.postCommentDao = postCommentDao;
        this.postTypeDao = postTypeDao;
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model, Principal principal) {
        //This prinicipal logic may be redundant or need to be deleted if spring security covers keeping logged in users away from this
        if(principal != null) {
            //which controller should this go to? profile?
            return "redirect:/profile";
        }
        model.addAttribute("user", new User());
        return "users/register";
    }

    //this is going to need to be refactored MAKE IT ALL A MAP or something.
    @PostMapping("/register")
    public String registerUser(@RequestParam(name = "skills-param") List<String> skillsStringList, @RequestParam String photoURL, @RequestParam String resumeURL, @RequestParam(required = false) String admin, @RequestParam(required = false) String instructor, @RequestParam(required = false) String alumnus, @RequestParam(required = false) String student, @ModelAttribute User user, Principal principal) {
        //This prinicipal logic may be redundant or need to be deleted if spring security covers keeping logged in users away from this
        if(principal != null) {
            //which controller should this go to? profile?
            return "redirect:/profile";
        }
        if((userDao.findUserByUsername(user.getUsername()) != null) || (userDao.findUserByEmail(user.getEmail()) != null) || photoURL == null || resumeURL == null) {
            //THIS SHOULD BE REPLACED WITH SOME TYPE OF ERROR MESSAGE ABOVE FORM THAT TELLS THEM TO CHOOSE A DIFFERENT USERNAME OR EMAIL, etc
            return "redirect:/register";
        }
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        user.setProfileImageURL(photoURL);
        user.setResumeURL(resumeURL);
        user = userDao.save(user);
        List<SecurityRole> userRoleList = new ArrayList<>();
        List<Skill> userSkillList = new ArrayList<>();
        if(admin != null) {
            if(securityRoleDao.findSecurityRoleByRole("ADMIN") == null) {
                SecurityRole addRole = new SecurityRole();
                addRole.setRole("ADMIN");
                List<User> userList = new ArrayList<>();
                userList.add(user);
                addRole.setUserList(userList);
                userRoleList.add(securityRoleDao.save(addRole));
            } else {
                SecurityRole updateRole = securityRoleDao.findSecurityRoleByRole("ADMIN");
                List<User> userList = updateRole.getUserList();
                userList.add(user);
                updateRole.setUserList(userList);
                userRoleList.add(securityRoleDao.save(updateRole));
            }
        }
        if(instructor != null) {
            if(securityRoleDao.findSecurityRoleByRole("INSTRUCTOR") == null) {
                SecurityRole addRole = new SecurityRole();
                addRole.setRole("INSTRUCTOR");
                List<User> userList = new ArrayList<>();
                userList.add(user);
                addRole.setUserList(userList);
                userRoleList.add(securityRoleDao.save(addRole));
            } else {
                SecurityRole updateRole = securityRoleDao.findSecurityRoleByRole("INSTRUCTOR");
                List<User> userList = updateRole.getUserList();
                userList.add(user);
                updateRole.setUserList(userList);
                userRoleList.add(securityRoleDao.save(updateRole));
            }
        }
        if(alumnus != null) {
            if(securityRoleDao.findSecurityRoleByRole("ALUMNUS") == null) {
                SecurityRole addRole = new SecurityRole();
                addRole.setRole("ALUMNUS");
                List<User> userList = new ArrayList<>();
                userList.add(user);
                addRole.setUserList(userList);
                userRoleList.add(securityRoleDao.save(addRole));
            } else {
                SecurityRole updateRole = securityRoleDao.findSecurityRoleByRole("ALUMNUS");
                List<User> userList = updateRole.getUserList();
                userList.add(user);
                updateRole.setUserList(userList);
                userRoleList.add(securityRoleDao.save(updateRole));
            }
        }
        if(student != null) {
            if(securityRoleDao.findSecurityRoleByRole("STUDENT") == null) {
                SecurityRole addRole = new SecurityRole();
                addRole.setRole("STUDENT");
                List<User> userList = new ArrayList<>();
                userList.add(user);
                addRole.setUserList(userList);
                userRoleList.add(securityRoleDao.save(addRole));
            } else {
                SecurityRole updateRole = securityRoleDao.findSecurityRoleByRole("STUDENT");
                List<User> userList = updateRole.getUserList();
                userList.add(user);
                updateRole.setUserList(userList);
                userRoleList.add(securityRoleDao.save(updateRole));
            }
        }
        for(String skill : skillsStringList) {
            if(skill != "") {
                if(skillDao.findSkillByName(skill) == null) {
                    Skill addSkill = new Skill();
                    addSkill.setName(skill);
                    List<User> userList = new ArrayList<>();
                    userList.add(user);
                    addSkill.setUserList(userList);
                    userSkillList.add(skillDao.save(addSkill));
                } else {
                    Skill updateSkill = skillDao.findSkillByName(skill);
                    List<User> userList = updateSkill.getUserList();
                    userList.add(user);
                    updateSkill.setUserList(userList);
                    userSkillList.add(skillDao.save(updateSkill));
                }
            }
        }
        //CONSIDER ADDING FEATURE WHERE AN ADMIN VERIFIES ALL ACCOUNTS AND PERMS if that is the case this will be set to false initially
        user.setActive(true);
        user.setRoleList(userRoleList);
        user.setSkillList(userSkillList);
        userDao.save(user);
        return "redirect:/login";
    }

    @GetMapping("/users/dashboard")
    public String profileView(Model model, Principal principal){
        List<Post> interviewQuestionsList = postDao.findAllByPostTypeId_Type("interview-questions").subList(postDao.findAllByPostTypeId_Type("interview-questions").size() - 2, postDao.findAllByPostTypeId_Type("interview-questions").size() - 1);
        interviewQuestionsList.sort(Collections.reverseOrder(Comparator.comparing((Post::getId))));
        List<Post> mentorshipPostsList = postDao.findAllByPostTypeId_Type("mentorship-posts").subList(postDao.findAllByPostTypeId_Type("mentorship-posts").size() - 2, postDao.findAllByPostTypeId_Type("mentorship-posts").size() - 1);
        mentorshipPostsList.sort(Collections.reverseOrder(Comparator.comparing((Post::getId))));
        List<Post> jobPostingsList = postDao.findAllByPostTypeId_Type("job-postings").subList(postDao.findAllByPostTypeId_Type("mentorship-posts").size() - 2, postDao.findAllByPostTypeId_Type("mentorship-posts").size() - 1);
        mentorshipPostsList.sort(Collections.reverseOrder(Comparator.comparing((Post::getId))));
        model.addAttribute("user", userDao.findUserByUsername(principal.getName()));
        model.addAttribute("interviewQuestionsList", interviewQuestionsList);
        model.addAttribute("mentorshipPostsList", mentorshipPostsList);
        model.addAttribute("jobPostingsList", jobPostingsList);
        return "users/dashboard";
    }
    @PostMapping("users/edit{id}/")
    public String profileEdit(@PathVariable long id, @ModelAttribute User user) {
        User updateInfo = userDao.getOne(id);
        updateInfo.setBio(user.getBio());
        userDao.save(updateInfo);
        return "redirect:/users/dashboard";
    }
}