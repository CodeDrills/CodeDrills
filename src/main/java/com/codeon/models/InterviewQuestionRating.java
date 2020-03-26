package com.codeon.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="interview_question_ratings")
public class InterviewQuestionRating {

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
    @JoinColumn (name = "interview_question_id")
    private JobSharingRecommendation question;

    public InterviewQuestionRating() {}

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

    public JobSharingRecommendation getQuestion() {
        return question;
    }

    public void setQuestion(JobSharingRecommendation question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "JobSharingRecommendationRating{" +
                "id=" + id +
                ", rating=" + rating +
                ", user=" + user +
                ", recommendation=" + question +
                '}';
    }
}