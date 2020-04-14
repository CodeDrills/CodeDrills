package com.codeon.repositories;

import com.codeon.models.Post;
import com.codeon.models.PostType;
import com.codeon.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {
    Post findPostById(long id);
    Post findPostByTitle(String title);
    Post findPostByPostTypeId(Long id);
    List <Post> getAllByUser_Id(Long id);
    List<Post> findAllByPostTypeId_Type(String type);
    List<Post> findAllByPostTypeId_TypeOrderByTitleAsc(String postType);
    List<Post> findAllByPostTypeId_TypeOrderByTitleDesc(String postType);
    List<Post> findAllByPostTypeId_TypeOrderByIdAsc(String postType);
    List<Post> findAllByPostTypeId_TypeOrderByIdDesc(String postType);
    List<Post> findAllByPostTypeId_TypeOrderByRatingTotalAsc(String postType);
    List<Post> findAllByPostTypeId_TypeOrderByRatingTotalDesc(String postType);
}
