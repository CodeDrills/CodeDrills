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
    @Column(name = "first_name",nullable = false, length = 50, unique = true)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 50, unique = true)
    private String lastName;
    @Column(nullable = false, length = 100, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(name = "profile_image_url", nullable = false)
    private String profileImageURL;
    @Column(nullable = false)
    private boolean isAdmin;
    @Column(nullable = false)
    private boolean isInstructor;
    @Column(nullable = false)
    private boolean isAlum;
    @Column(nullable = false)
    private boolean isStudent;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> postList;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<PostComment> commentList;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<PostRating> ratingList;


    public User() {}

    //added copy constructor for spring security
    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        username = copy.username;
        password = copy.password;
        isAdmin = copy.isAdmin;
        isInstructor = copy.isInstructor;
        isAlum = copy.isAlum;
        isStudent = copy.isStudent;
        postList = copy.postList;
        commentList = copy.commentList;
        ratingList = copy.ratingList;
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

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isInstructor() {
        return isInstructor;
    }

    public void setInstructor(boolean instructor) {
        isInstructor = instructor;
    }

    public boolean isAlum() {
        return isAlum;
    }

    public void setAlum(boolean alum) {
        isAlum = alum;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public List<PostComment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<PostComment> commentList) {
        this.commentList = commentList;
    }

    public List<PostRating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<PostRating> ratingList) {
        this.ratingList = ratingList;
    }

    public String getProfileImageURL() {
        return profileImageURL;
    }

    public void setProfileImageURL(String profileImageURL) {
        this.profileImageURL = profileImageURL;
    }
}
