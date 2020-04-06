package com.codeon.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="security_roles")
public class SecurityRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String role;
    @ManyToMany(mappedBy = "roleList")
    private List<User> userList;
    @ManyToMany(mappedBy = "roleList")
    private List<ApprovedEmail> approvedEmailList;

    public SecurityRole() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<ApprovedEmail> getApprovedEmailList() {
        return approvedEmailList;
    }

    public void setApprovedEmailList(List<ApprovedEmail> approvedEmailList) {
        this.approvedEmailList = approvedEmailList;
    }
}
