package com.codeon.repositories;

import com.codeon.models.PostType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostTypeRepo extends JpaRepository<PostType, Long> {
    public PostType getPostTypeById(Long id);
}
