package com.codeon.repositories;

import com.codeon.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {
    public Post findPostById(long id);
    public Post findPostByTitle(String title);
    public Post findPostByPostTypeId(Long id);

    public List<Post> findAllByPostTypeId_Type(String type);
}
