package com.codeon.repositories;

import com.codeon.models.PostType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostTypeRepo extends JpaRepository<PostType, Long> {
    PostType getPostTypeById(Long id);
    PostType getPostTypeByType(String type);
}
