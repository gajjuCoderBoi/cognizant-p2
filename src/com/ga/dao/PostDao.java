package com.ga.dao;

import com.ga.entity.Comment;
import com.ga.entity.Post;

import java.util.List;


public interface PostDao {

    public Post addPost(Post post, String username);

    public List<Post> listPost();

    public List<Post> listPostByUser(String username);

    public Post addComment(Long postId, Comment commentId);

     public Post getPostById(Long postId);



}

//do this on user?
//    public List<Post> getPostByUser();

//    public Post getPostById(Long postId);
//    public Post editPost(Post post);
//    public Post deletePost(Long postId);
