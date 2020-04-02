package com.codeon.repositories;

import com.codeon.models.PostCommentRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCommentRatingRepo extends JpaRepository<PostCommentRating, Long> {
    public PostCommentRating getRatingById(Long id);
}