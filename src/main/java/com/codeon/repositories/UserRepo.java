package com.codeon.repositories;
import com.codeon.models.SecurityRole;
import com.codeon.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
    User findUserByEmail(String email);
    User findUserById(Long id);
    List<User> findAllByRoleList_Role(String role);
}
