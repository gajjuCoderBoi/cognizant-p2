package com.ga.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column
    private String commentText;

    public Comment() {
    }

    public Comment(Long commentId, String commentText, User user, Post post) {
        this.commentText = commentText;
        this.user = user;
        this.post = post;
        this.commentId = commentId;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }


    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    /*@JoinTable(name = "user_comment",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "comment_id"))*/
    @JoinColumn(name = "user_id")
    private User user;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    /*@JoinTable(name = "post_comment",
            joinColumns = {@JoinColumn(name = "post_id")},
            inverseJoinColumns = @JoinColumn(name = "comment_id"))*/
    @JoinColumn(name = "post_id")
    private Post post;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return user != null ?
                user.getUsername() :
                "";
    }

    public String getPostTitle() {
        return post != null ?
                post.getTitle() :
                "";
    }

    public String getpostid() {
        return post != null ?
                String.valueOf(post.getPostId(anyLong())) :
                "";
    }


    public Long getPostId(Long postId) {
        return postId;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

}
