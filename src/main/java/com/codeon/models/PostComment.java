package com.codeon.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="post_comments")
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String body;

    @JsonBackReference
    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

    @JsonBackReference
    @ManyToOne
    @JoinColumn (name = "post_id")
    private Post post;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postComment")
    private List<PostCommentRating> commentRatingList;

    @Column(nullable = false)
    @Formula(value = "(SELECT sum(r.rating) FROM post_comment_ratings r WHERE r.post_comment_id = id)")
    private Integer ratingTotal;

    @Column
    private String dateTime;

    public PostComment() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public List<PostCommentRating> getCommentRatingList() {
        return commentRatingList;
    }

    public void setCommentRatingList(List<PostCommentRating> commentRatingList) {
        this.commentRatingList = commentRatingList;
    }

    public Integer getRatingTotal() {
        return ratingTotal;
    }

    public void setRatingTotal(Integer ratingTotal) {
        this.ratingTotal = ratingTotal;
    }

    public void setRatingTotal(List<PostCommentRating> ratingList) {
        Integer total = 0;
        for(PostCommentRating postCommentRating : ratingList) {
            total += postCommentRating.getRating();
        }
        this.ratingTotal = total;
    }

    public Integer getRatingTotal(List<PostCommentRating> ratingList) {
        Integer total = 0;
        for(PostCommentRating postCommentRating : ratingList) {
            total += postCommentRating.getRating();
        }
        return total;
    }
}
