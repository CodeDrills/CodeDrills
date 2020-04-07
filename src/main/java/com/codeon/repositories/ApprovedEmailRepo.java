package com.codeon.repositories;

import com.codeon.models.ApprovedEmail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprovedEmailRepo extends JpaRepository<ApprovedEmail, Long> {
    ApprovedEmail findApprovedEmailByEmail(String email);
}
