package com.ga.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
public class  Post {


    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column
    private String title;

    @Column
    private String postText;

    public Post(Long postId,String title, String postText, User user, List<Comment> comments) {
        this.title = title;
        this.postText = postText;
        this.user = user;
        this.comments = comments;
        this.postId = postId;
    }

    public Post() {}

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;



    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "post",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getPostId(long l) {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public String getUserName() {
        return user.getUsername();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public List<Comment> addComments(Comment comment) {
        if(comments == null)
            comments = new ArrayList<>();

        comments.add(comment);
        return comments;
    }

}
