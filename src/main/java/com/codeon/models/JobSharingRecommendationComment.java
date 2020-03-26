package com.codeon.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="job_sharing_recommendation_comments")
public class JobSharingRecommendationComment {
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
    @JoinColumn (name = "job_sharing_recommendation_id")
    private JobSharingRecommendation recommendation;

    public JobSharingRecommendationComment() {}

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

    public JobSharingRecommendation getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(JobSharingRecommendation recommendation) {
        this.recommendation = recommendation;
    }

    @Override
    public String toString() {
        return "JobSharingRecommendationComment{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", user=" + user +
                ", recommendation=" + recommendation +
                '}';
    }
}
