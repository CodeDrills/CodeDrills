package com.codeon.repositories;

import com.codeon.models.SecurityRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SecurityRoleRepo extends JpaRepository<SecurityRole, Long> {
    List<SecurityRole> findAllByApprovedEmailList_Email(String email);
    SecurityRole findSecurityRoleByRole(String role);
}
