package com.codeon.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "mentorship_posts")
public class MentorshipPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title ;

    @Column(nullable = false, length = 200)
    private String body ;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<MentorshipPostComment> commentList;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<MentorshipPostRating> ratingList;

    @Column(nullable = false)
    private Integer ratingTotal;

    public MentorshipPost() {}

    public void setRatingTotal(List<Integer> ratingsList) {
        Integer sum = 0;
        for(Integer rating : ratingsList) {
            sum += rating;
        }
        this.ratingTotal = sum;
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

    public List<MentorshipPostComment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<MentorshipPostComment> commentList) {
        this.commentList = commentList;
    }

    public List<MentorshipPostRating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<MentorshipPostRating> ratingList) {
        this.ratingList = ratingList;
    }

    public Integer getRatingTotal() {
        return ratingTotal;
    }

    public void setRatingTotal(Integer ratingTotal) {
        this.ratingTotal = ratingTotal;
    }

    @Override
    public String toString() {
        return "MentorshipPost{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", user=" + user +
                ", commentList=" + commentList +
                ", ratingList=" + ratingList +
                ", ratingTotal=" + ratingTotal +
                '}';
    }
}