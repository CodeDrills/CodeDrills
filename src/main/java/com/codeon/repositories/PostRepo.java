package com.codeon.repositories;

import com.codeon.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Long> {
    public Post findPostById(long id);
    public Post findPostByTitle(String title);
}
