package com.codeon.controllers;

import com.codeon.models.*;
import com.codeon.repositories.*;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${filestack.api.key}")
    private String filestackKey;
    @Value("${talkjs.app.id}")
    private String talkJSAppId;
    private UserRepo userDao;
    private PasswordEncoder passwordEncoder;
    private SecurityRoleRepo securityRoleDao;
    private SkillRepo skillDao;
    private PostRepo postDao;
    private PostCommentRepo postCommentDao;
    private PostTypeRepo postTypeDao;
    private ApprovedEmailRepo approvedEmailDao;

    public UserController(UserRepo userDao, PasswordEncoder passwordEncoder, SecurityRoleRepo securityRoleDao, SkillRepo skillDao, PostRepo postDao, PostCommentRepo postCommentDao, PostTypeRepo postTypeDao, ApprovedEmailRepo approvedEmailDao) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.securityRoleDao = securityRoleDao;
        this.skillDao = skillDao;
        this.postDao = postDao;
        this.postCommentDao = postCommentDao;
        this.postTypeDao = postTypeDao;
        this.approvedEmailDao = approvedEmailDao;
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model, Principal principal) {
        //This prinicipal logic may be redundant or need to be deleted if spring security covers keeping logged in users away from this
        if(principal != null) {
            return "redirect:/users/dashboard";
        }
        model.addAttribute("user", new User());
        model.addAttribute("filestackKey", filestackKey);
        return "users/register";
    }

    //this is going to need to be refactored MAKE IT ALL A MAP or something.
    @PostMapping("/register")
    public String registerUser(@RequestParam(name = "skills-param") List<String> skillsStringList, @RequestParam String photoURL, @RequestParam String resumeURL, @ModelAttribute User user, Principal principal) {
        //This prinicipal logic may be redundant or need to be deleted if spring security covers keeping logged in users away from this
        if(principal != null) {
            //which controller should this go to? profile?
            return "redirect:/users/dashboard";
        }
        if((userDao.findUserByUsername(user.getUsername()) != null) || (userDao.findUserByEmail(user.getEmail()) != null) || (approvedEmailDao.findApprovedEmailByEmail(user.getEmail()) == null)) {
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
        for(SecurityRole role : securityRoleDao.findAllByApprovedEmailList_Email(user.getEmail())) {
            userRoleList.add(securityRoleDao.findSecurityRoleByRole(role.getRole()));
        }

        for(String skill : skillsStringList) {
            if(!skill.equals("")) {
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
        user.setActive(true);
        user.setRoleList(userRoleList);
        user.setSkillList(userSkillList);
        userDao.save(user);
        return "redirect:/login";
    }

    @GetMapping("/users/dashboard")
    public String profileView(Model model, Principal principal){
        List<Post> interviewQuestionsList = postDao.findAllByPostTypeId_Type("interview-questions").subList(postDao.findAllByPostTypeId_Type("interview-questions").size() - 2, postDao.findAllByPostTypeId_Type("interview-questions").size());
        interviewQuestionsList.sort(Collections.reverseOrder(Comparator.comparing(Post::getId)));
        List<Post> mentorshipPostsList = postDao.findAllByPostTypeId_Type("mentorship-posts").subList(postDao.findAllByPostTypeId_Type("mentorship-posts").size() - 2, postDao.findAllByPostTypeId_Type("mentorship-posts").size());
        mentorshipPostsList.sort(Collections.reverseOrder(Comparator.comparing(Post::getId)));
        List<Post> jobPostingsList = postDao.findAllByPostTypeId_Type("job-postings").subList(postDao.findAllByPostTypeId_Type("job-postings").size() - 2, postDao.findAllByPostTypeId_Type("job-postings").size());
        jobPostingsList.sort(Collections.reverseOrder(Comparator.comparing(Post::getId)));
        model.addAttribute("post", new Post());
        model.addAttribute("user", userDao.findUserByUsername(principal.getName()));
        model.addAttribute("talkJSAppId", talkJSAppId);
        model.addAttribute("interviewQuestionsList", interviewQuestionsList);
        model.addAttribute("mentorshipPostsList", mentorshipPostsList);
        model.addAttribute("jobPostingsList", jobPostingsList);
        model.addAttribute("interviewPost", new Post());
        model.addAttribute("mentorshipPost", new Post());
        model.addAttribute("jobcreatePost", new Post());
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