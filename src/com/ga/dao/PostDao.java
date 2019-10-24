package com.ga.dao;

import com.ga.entity.Comment;
import com.ga.entity.Post;

import java.util.List;


public interface PostDao {

    public Post addPost(Post post, String username);

    public List<Post> listPost();

    public List<Post> listPostByUser(String username);

    public Comment addComment(Long postId, Comment commentId, String username);

     public Post getPostById(Long postId);

    public Post updatePost(Long postId, Post post, String username);

    public Long deletePost(Long postId, String username);
}
