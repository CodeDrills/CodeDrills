package com.codeon.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="job_sharing_recommendation_ratings")
public class JobSharingRecommendationRating {

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
    @JoinColumn (name = "job_sharing_recommendation_id")
    private JobSharingRecommendation recommendation;

    public JobSharingRecommendationRating() {}

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

    public JobSharingRecommendation getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(JobSharingRecommendation recommendation) {
        this.recommendation = recommendation;
    }

    @Override
    public String toString() {
        return "JobSharingRecommendationRating{" +
                "id=" + id +
                ", rating=" + rating +
                ", user=" + user +
                ", recommendation=" + recommendation +
                '}';
    }
}
