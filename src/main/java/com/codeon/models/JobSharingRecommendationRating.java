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
}
