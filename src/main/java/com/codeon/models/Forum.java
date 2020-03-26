package com.codeon.models;


import javax.persistence.*;


@Entity
@Table(name = "forum")
public class Forum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 200)
    private String forumtitle ;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Forum() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getForumtitle() {
        return forumtitle;
    }

    public void setForumtitle(String forumtitle) {
        this.forumtitle = forumtitle;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }



}