package com.codeon.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="mentorship_post_ratings")
public class MentorshipPostRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer rating;
    @JsonBackReference
    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;
    @JsonBackReference
    @ManyToOne
    @JoinColumn (name = "mentorship_post_id")
    private MentorshipPost post;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MentorshipPost getMessage() {
        return post;
    }

    public void setMessage(MentorshipPost post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "MentorshipPostRating{" +
                "id=" + id +
                ", rating=" + rating +
                ", user=" + user +
                ", post=" + post +
                '}';
    }
}
