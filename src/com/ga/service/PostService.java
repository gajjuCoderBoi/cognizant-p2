package com.ga.service;

import com.ga.entity.Comment;
import com.ga.entity.Post;

import java.util.List;

public interface PostService {

    public Post addPost(Post post, String token);

        public List<Post> listPost();

    public Post addComment(Long postId, Comment comment);

}

//    public Post getPostById(Long postId);
//    public Post editPost(Post post);
//    public Post deletePost(Long postId);
