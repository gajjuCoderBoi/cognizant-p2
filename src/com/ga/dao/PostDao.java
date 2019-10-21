package com.ga.dao;

import com.ga.entity.Post;

import java.util.List;

public interface PostDao {
    public List<Post> listPost();
    public Post getPostById(Long postId);
    public Post addPost(Post post);
    public Post editPost(Post post);
    public Post deletePost(Long postId);
}

//do this on user?
//    public List<Post> getPostByUser();
