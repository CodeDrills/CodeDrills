package com.codeon.models;


import javax.persistence.*;

@Entity
@Table(name="mentorship_post_comments")
public class MentorshipPostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String body;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn (name = "mentorship_post_id")
    private MentorshipPost post;

    public MentorshipPostComment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public MentorshipPost getPost() {
        return post;
    }

    public void setPost(MentorshipPost post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "MentorshipPostComment{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", user=" + user +
                ", post=" + post +
                '}';
    }
}



