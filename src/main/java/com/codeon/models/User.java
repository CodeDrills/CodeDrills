package com.codeon.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity(name="User") @Table(name="users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 50, unique = true)
    private String username;
    @Column(nullable = false, length = 100, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private boolean isAdmin;
    @Column(nullable = false)
    private boolean isAlum;
    @Column(nullable = false)
    private boolean isInstructor;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user") //changed the case to singular
    private List<JobSharingRecommendation> jobSharingRecommendationList;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user") //changed the case to singular
    private List<JobSharingRecommendationComment> jobSharingRecommendationCommentList;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user") //changed the case to singular
    private List<JobSharingRecommendationRating> jobSharingRecommendationRatingList;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user") //changed the case to singular
    private List<InterviewQuestion> interviewQuestionList;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user") //changed the case to singular
    private List<InterviewQuestionComment> interviewQuestionCommentList;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user") //changed the case to singular
    private List<InterviewQuestionRating> interviewQuestionRatingList;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user") //changed the case to singular
    private List<MentorshipPost> mentorshipPostList;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user") //changed the case to singular
    private List<MentorshipPostComment> mentorshipPostCommentList;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user") //changed the case to singular
    private List<MentorshipPostRating> mentorshipPostRatingList;

    public User() {}

    //added copy constructor for spring security
    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        username = copy.username;
        password = copy.password;
        isAdmin = copy.isAdmin;
        isAlum = copy.isAlum;
        isInstructor = copy.isInstructor;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isAlum() {
        return isAlum;
    }

    public void setAlum(boolean alum) {
        isAlum = alum;
    }

    public boolean isInstructor() {
        return isInstructor;
    }

    public void setInstructor(boolean instructor) {
        isInstructor = instructor;
    }

    public List<JobSharingRecommendation> getJobSharingRecommendationList() {
        return jobSharingRecommendationList;
    }

    public void setJobSharingRecommendationList(List<JobSharingRecommendation> jobSharingRecommendationList) {
        this.jobSharingRecommendationList = jobSharingRecommendationList;
    }

    public List<JobSharingRecommendationComment> getJobSharingRecommendationCommentList() {
        return jobSharingRecommendationCommentList;
    }

    public void setJobSharingRecommendationCommentList(List<JobSharingRecommendationComment> jobSharingRecommendationCommentList) {
        this.jobSharingRecommendationCommentList = jobSharingRecommendationCommentList;
    }

    public List<JobSharingRecommendationRating> getJobSharingRecommendationRatingList() {
        return jobSharingRecommendationRatingList;
    }

    public void setJobSharingRecommendationRatingList(List<JobSharingRecommendationRating> jobSharingRecommendationRatingList) {
        this.jobSharingRecommendationRatingList = jobSharingRecommendationRatingList;
    }

    public List<InterviewQuestion> getInterviewQuestionList() {
        return interviewQuestionList;
    }

    public void setInterviewQuestionList(List<InterviewQuestion> interviewQuestionList) {
        this.interviewQuestionList = interviewQuestionList;
    }

    public List<InterviewQuestionComment> getInterviewQuestionCommentList() {
        return interviewQuestionCommentList;
    }

    public void setInterviewQuestionCommentList(List<InterviewQuestionComment> interviewQuestionCommentList) {
        this.interviewQuestionCommentList = interviewQuestionCommentList;
    }

    public List<InterviewQuestionRating> getInterviewQuestionRatingList() {
        return interviewQuestionRatingList;
    }

    public void setInterviewQuestionRatingList(List<InterviewQuestionRating> interviewQuestionRatingList) {
        this.interviewQuestionRatingList = interviewQuestionRatingList;
    }

    public List<MentorshipPost> getMentorshipPostList() {
        return mentorshipPostList;
    }

    public void setMentorshipPostList(List<MentorshipPost> mentorshipPostList) {
        this.mentorshipPostList = mentorshipPostList;
    }

    public List<MentorshipPostComment> getMentorshipPostCommentList() {
        return mentorshipPostCommentList;
    }

    public void setMentorshipPostCommentList(List<MentorshipPostComment> mentorshipPostCommentList) {
        this.mentorshipPostCommentList = mentorshipPostCommentList;
    }

    public List<MentorshipPostRating> getMentorshipPostRatingList() {
        return mentorshipPostRatingList;
    }

    public void setMentorshipPostRatingList(List<MentorshipPostRating> mentorshipPostRatingList) {
        this.mentorshipPostRatingList = mentorshipPostRatingList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                ", isAlum=" + isAlum +
                ", isInstructor=" + isInstructor +
                ", jobSharingRecommendationList=" + jobSharingRecommendationList +
                ", jobSharingRecommendationCommentList=" + jobSharingRecommendationCommentList +
                ", jobSharingRecommendationRatingList=" + jobSharingRecommendationRatingList +
                ", interviewQuestionList=" + interviewQuestionList +
                ", interviewQuestionCommentList=" + interviewQuestionCommentList +
                ", interviewQuestionRatingList=" + interviewQuestionRatingList +
                ", mentorshipPostList=" + mentorshipPostList +
                ", mentorshipPostCommentList=" + mentorshipPostCommentList +
                ", mentorshipPostRatingList=" + mentorshipPostRatingList +
                '}';
    }
}
