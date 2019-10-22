package com.ga.service;

import com.ga.entity.Post;

import java.util.List;

public interface PostService {

    public Post addPost(Post post);

        public List<Post> listPost();

}

//    public Post getPostById(Long postId);
//    public Post editPost(Post post);
//    public Post deletePost(Long postId);
