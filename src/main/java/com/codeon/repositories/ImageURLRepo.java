package com.codeon.repositories;

import com.codeon.models.ImageURL;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageURLRepo extends JpaRepository<ImageURL, Long> {
}
