package com.codeon.repositories;

import com.codeon.models.PostRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRatingRepo extends JpaRepository<PostRating, Long> {
    public PostRating getRatingById(Long id);
}