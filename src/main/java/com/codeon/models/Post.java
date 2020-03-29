package com.codeon.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(length = 100)
    private String employer;

    @Column(nullable = false)
    private String body;

    @JsonBackReference
    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

    @JsonBackReference
    @ManyToOne
    @JoinColumn (name = "post_type_id")
    private PostType postType;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<ImageURL> imageURLList;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<PostComment> commentList;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<PostRating> ratingList;

    @Column(nullable = false)
    private Integer ratingTotal;

    @Column
    private String dateTime;

    public Post() {}

    public Post(String title,String body,String dateTime) {
        this.title = title;
        this.body = body;
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Integer getRatingTotal() {
        return ratingTotal;
    }

    public void setRatingTotal(Integer ratingTotal) {
        this.ratingTotal = ratingTotal;
    }

    public void setRatingTotal(List<PostRating> ratingList) {
        Integer total = 0;
        for(PostRating postRating : ratingList) {
            total += postRating.getRating();
        }
        this.ratingTotal = total;
    }

    public List<ImageURL> getImageURLList() {
        return imageURLList;
    }

    public void setImageURLList(List<ImageURL> imageURLList) {
        this.imageURLList = imageURLList;
    }

    public PostType getPostType() {
        return postType;
    }

    public void setPostType(PostType postType) {
        this.postType = postType;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", employer='" + employer + '\'' +
                ", body='" + body + '\'' +
                ", user=" + user +
                ", postType=" + postType +
                ", imageURLList=" + imageURLList +
                ", commentList=" + commentList +
                ", ratingList=" + ratingList +
                ", ratingTotal=" + ratingTotal +
                ", dateTime=" + dateTime +
                '}';
    }

}
