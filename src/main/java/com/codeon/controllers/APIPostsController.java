package com.codeon.controllers;

import com.codeon.models.Post;

import com.codeon.repositories.PostRepo;
import com.codeon.repositories.UserRepo;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.*;

@Controller
public class APIPostsController {
    @Value("${filestack.api.key}")
    private String filestackKey;
    @Value("${talkjs.app.id}")
    private String talkJSAppId;

    private Random random = new Random();
    private PostRepo postDao;
    private UserRepo userDao;

    public APIPostsController(PostRepo postDao, UserRepo userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/api/interview-questions")
    public String getInterviewQuestionsView(Model model, Principal principal) {
        model.addAttribute("filestackKey", filestackKey);
        model.addAttribute("user", userDao.findUserByUsername(principal.getName()));
        model.addAttribute("talkJSAppId", talkJSAppId);
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
        List<Post> postList = postDao.findAllByPostTypeId_Type(postType);
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
    @GetMapping("/api/{postType}/sort")
    @ResponseBody
    public List <Post> getSortedPosts(@PathVariable String postType, @RequestParam String by) {
        List<Post> postList = new ArrayList<>();
        switch (by) {
            case "titleAsc":
                postList = postDao.findAllByPostTypeId_TypeOrderByTitleAsc(postType);
                break;
            case "titleDesc":
                postList = postDao.findAllByPostTypeId_TypeOrderByTitleDesc(postType);
                break;
            case "newest":
                postList = postDao.findAllByPostTypeId_TypeOrderByIdAsc(postType);
                break;
            case "oldest":
                postList = postDao.findAllByPostTypeId_TypeOrderByIdDesc(postType);
                break;
            case "highestRating":
                postList = postDao.findAllByPostTypeId_TypeOrderByRatingTotalDesc(postType);
                break;
            case "lowestRating":
                postList = postDao.findAllByPostTypeId_TypeOrderByRatingTotalAsc(postType);
                break;
            default:
                break;
        }
        return postList;
    }


}
