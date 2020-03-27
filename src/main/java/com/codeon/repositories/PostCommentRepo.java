package com.codeon.repositories;

import com.codeon.models.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCommentRepo extends JpaRepository<PostComment, Long> {
    public PostComment getPostCommentById(Long id);
}
