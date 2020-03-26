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
    private InterviewQuestion question;

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

    public InterviewQuestion getQuestion() {
        return question;
    }

    public void setQuestion(InterviewQuestion question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "InterviewQuestionRating{" +
                "id=" + id +
                ", rating=" + rating +
                ", user=" + user +
                ", question=" + question +
                '}';
    }
}