package com.codeon.repositories;

import com.codeon.models.Post;
import com.codeon.models.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostCommentRepo extends JpaRepository<PostComment, Long> {
    public PostComment getPostCommentById(Long id);
    public List<PostComment> getAllByUser_Id(Long id);
}
