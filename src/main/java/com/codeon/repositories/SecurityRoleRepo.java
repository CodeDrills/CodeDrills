package com.codeon.repositories;

import com.codeon.models.SecurityRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SecurityRoleRepo extends JpaRepository<SecurityRole, Long> {
    //below is broken? maybe needs seeder but that doesnt make sense. it isnt needede
//    public List<SecurityRole> findAllBySecurityRoleId_UserId(Long userId);
}
