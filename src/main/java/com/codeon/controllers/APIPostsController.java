package com.codeon.controllers;

import com.codeon.models.Post;

import com.codeon.repositories.PostRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.*;


//Probably could trim this down to a few getMappings by using {post-type} and then switch statement

@Controller
public class APIPostsController {

    private Random random = new Random();
    private PostRepo postDao;

    public APIPostsController(PostRepo postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/api/interview-questions")
    public String getInterviewQuestionsView() {
        return "questions/show";
    }

    @GetMapping("/api/questions/all")
    @ResponseBody
    public List<Post> getQuestions() {
        List <Post> merged = postDao.findAllByPostTypeId_Type("interview-questions");
        merged.addAll(postDao.findAllByPostTypeId_Type("whiteboard-questions"));
        merged.sort(Collections.reverseOrder(Comparator.comparing((Post::getId))));
        return merged;
    }

    @GetMapping("/api/{postType}/{id}")
    @ResponseBody
    public Object getPost(@PathVariable String postType, @PathVariable Long id) {
        List <Post> postList = new ArrayList<>();
        if(postType.equals("interview-questions")) {
            postList = postDao.findAllByPostTypeId_Type("interview-questions");
            for(Post post: postList) {
                if(post.getId() == id) {
                    return postDao.findPostById(id);
                }
            }
        } else if(postType.equals("whiteboard-questions")) {
            postList = postDao.findAllByPostTypeId_Type("whiteboard-questions");
            for(Post post: postList) {
                if(post.getId() == id) {
                    return postDao.findPostById(id);
                }
            }
        }
        return "-1";
    }
    @GetMapping("/api/{postType}/show-one")
    @ResponseBody
    public Post getPostAlg(@PathVariable String postType) {
        List<Post> postList;
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
            default:
                postList = postDao.findAllByPostTypeId_Type("whiteboard-questions");
                break;
        }
        Post selectedPost = null;
        Integer pickQuestion, questionRoll, selectedPostRating;
        boolean determiningPost = true;
        while(determiningPost) {
            pickQuestion = random.nextInt(postList.size());
            selectedPost = postList.get(pickQuestion);
            selectedPostRating = selectedPost.getRatingTotal(selectedPost.getRatingList());
            questionRoll = random.nextInt(31) -10;
            if(selectedPostRating >= questionRoll) {
                determiningPost = false;
            }
        }
        return selectedPost;
    }

    @GetMapping("/job-postings/show/by-rating")
    public String showAllJobPostingsByRating(Model model, Principal principal) {
        model.addAttribute("user", userDao.findUserByUsername(principal.getName()));
        List<Post> jobPostings = postDao.findAllByPostTypeId_Type("job-postings");
        jobPostings.sort(Collections.reverseOrder(Comparator.comparing(Post::getRatingTotal)));
        model.addAttribute("postList", jobPostings);
        return "job-postings/show";
    }
}
