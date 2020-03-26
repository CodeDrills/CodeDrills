package com.codeon.models;


import javax.persistence.*;


@Entity
@Table(name = "mentorship_message_board")
public class MentorshipMessageBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 200)
    private String messageBoard_title ;

    @Column(nullable = false, length = 200)
    private String messageBoard_body ;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public MentorshipMessageBoard() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessageBoard_title() {
        return messageBoard_title;
    }

    public void setMessageBoard_title(String messageBoard_title ) {
        this.messageBoard_title = messageBoard_title ;
    }

    public String getMessageBoard_body() {
        return messageBoard_body;
    }

    public void setMessageBoard_body(String messageBoard_body) {
        this.messageBoard_body= messageBoard_body;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }



}