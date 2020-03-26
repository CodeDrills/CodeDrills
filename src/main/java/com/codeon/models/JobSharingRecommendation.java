package com.codeon.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="job_sharing_recommendations")
public class JobSharingRecommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 100)
    private String employer;

    @Column(nullable = false)
    private String body;

    @JsonBackReference
    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recommendation")
    private List<JobSharingRecommendationComment> commentsList;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recommendation")
    private List<JobSharingRecommendationRating> ratingsList;

    @Column(nullable = true)
    private Integer ratingAverage;


    public JobSharingRecommendation() {
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

    public List<JobSharingRecommendationComment> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<JobSharingRecommendationComment> commentsList) {
        this.commentsList = commentsList;
    }

    public List<JobSharingRecommendationRating> getRatingsList() {
        return ratingsList;
    }

    public void setRatingsList(List<JobSharingRecommendationRating> ratingsList) {
        this.ratingsList = ratingsList;
    }

    public Integer getRatingAverage() {
        return ratingAverage;
    }

    public void setRatingAverage(Integer ratingAverage) {
        this.ratingAverage = ratingAverage;
    }

    public void setRatingAverage(List<Integer> ratingsList, Integer newRating) {
        Integer intTotal = newRating;
        Integer counter = ratingsList.size() + 1;
        for(Integer rating : ratingsList) {
            intTotal += rating;
        }
        this.ratingAverage = intTotal / counter;
    }
}
