package com.ga.service;

import com.ga.entity.Comment;
import com.ga.entity.Post;

import java.util.List;

public interface PostService {

    public Post addPost(Post post, String token);

    public List<Post> listPost();

    public List<Post> listPostByUser(String token);

    public Post addComment(Long postId, Comment comment);

    public Post updatePost(Long postId, Post post, String token);

    public Long deletePost(Long postId, String token);
}

