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
//    @JsonBackReference
//    @ManyToOne
//    @JoinColumn (name = "user_id")
//    private User user;
    @ManyToMany(mappedBy = "roleList")
    private List<User> userList;
    @JsonBackReference
    @ManyToOne
    @JoinColumn (name = "approved_email_id")
    private ApprovedEmail approvedEmail;

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

    public ApprovedEmail getApprovedEmail() {
        return approvedEmail;
    }

    public void setApprovedEmail(ApprovedEmail approvedEmail) {
        this.approvedEmail = approvedEmail;
    }
}
