package com.codeon.models;


import javax.persistence.*;

@Entity
@Table(name="mentorshipMessage_comments")
public class MentorshipMessageComments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String body;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn (name = "mentorshipMessageBoard_id")
    private MentorshipMessageBoard mentorshipMessageBoard;

    public MentorshipMessageComments() {
    }

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

    public MentorshipMessageBoard getMentorshipMessageBoard() {
        return mentorshipMessageBoard;
    }

    public void setMentorshipMessageBoard(MentorshipMessageBoard mentorshipMessageBoard) {
        this.mentorshipMessageBoard = mentorshipMessageBoard;
    }
}



