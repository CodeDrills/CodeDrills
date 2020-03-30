package com.codeon.repositories;

import com.codeon.models.Post;
import com.codeon.models.PostType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {
    public Post findPostById(long id);
    public Post findPostByTitle(String title);
    public Post findPostByPostTypeId(Long id);
    //bellow was throwing errors. did not modify just commented out for compiling
//    List<Post> getAllPostbyusersid (long id);
    List <Post> getAllByUser_Id(Long id);
    public List<Post> findAllByPostTypeId_Type(String type);

}
