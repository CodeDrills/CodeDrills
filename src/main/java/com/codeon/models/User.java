package com.codeon.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity(name="User") @Table(name="users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 50, unique = true)
    private String username;
    @Column(nullable = false, length = 100, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private boolean isAdmin;
    @Column(nullable = false)
    private boolean isAlum;
    @Column(nullable = false)
    private boolean isInstructor;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user") //changed the case to singular
    private List<Post> postList;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user") //changed the case to singular
    private List<JobSharingRecommendation> jobSharingRecommendationList;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user") //changed the case to singular
    private List<JobSharingRecommendationComment> jobSharingRecommendationCommentList;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user") //changed the case to singular
    private List<JobSharingRecommendationRating> jobSharingRecommendationRatingList;

    public User() {}
    //added copy constructor for spring security
    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        username = copy.username;
        password = copy.password;
        isAdmin = copy.isAdmin;
        isAlum = copy.isAlum;
        isInstructor = copy.isInstructor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isAlum() {
        return isAlum;
    }

    public void setAlum(boolean alum) {
        isAlum = alum;
    }

    public boolean isInstructor() {
        return isInstructor;
    }

    public void setInstructor(boolean instructor) {
        isInstructor = instructor;
    }
}
