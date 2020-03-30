package com.codeon.controllers;

import com.codeon.models.Post;

import com.codeon.models.User;
import com.codeon.repositories.PostRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.Random;




@Controller
public class APIQuestionsController {

    private Random random = new Random();
    private PostRepo postDao;

    public APIQuestionsController(PostRepo postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/api/questions")
    public String getQuestionView() {
        return "questions/show";
    }


    @GetMapping("/api/questions/{id}")
    @ResponseBody
    public Post getQuestion(@PathVariable Long id) {
        return postDao.findPostById(id);

    }


    @GetMapping("/api/questions/show-one")
    @ResponseBody
    public Post getQuestion() {
        List<Post> interviewQuestions = postDao.findAllByPostTypeId_Type("interview_question");
        Post selectedPost = null;
        Integer pickQuestion, questionRoll, selectedPostRating;
        boolean determiningPost = true;
        while(determiningPost) {
            pickQuestion = random.nextInt(interviewQuestions.size());
            System.out.println("Selecting Question: " + pickQuestion);
            selectedPost = interviewQuestions.get(pickQuestion);
            selectedPostRating = selectedPost.getRatingTotal(selectedPost.getRatingList());
            System.out.println(selectedPostRating);
            questionRoll = random.nextInt(31) -10;
            if(selectedPostRating >= questionRoll) {
                determiningPost = false;
            }
        }
        return selectedPost;
    }

}
