package com.codeon.repositories;

import com.codeon.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {
    public Post findPostById(long id);
    public Post findPostByTitle(String title);
    public Post findPostByPostTypeId(Long id);
    public List<Post> findAllByPostTypeId(Long post_type_id);
    public List<Post> findAllByPostTypeId_Type(String type);

    //Selects only posts of type 'interview_question'
    @Query(value = "select * from posts p join post_types t on p.post_type_id = t.id where t.type = 'interview_question'",
           nativeQuery = true)
    public List<Post> findAllPostsInterviewQuestions();
}
