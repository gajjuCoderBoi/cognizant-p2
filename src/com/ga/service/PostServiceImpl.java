package com.ga.service;

import com.ga.config.JwtUtil;
import com.ga.dao.PostDao;
import com.ga.entity.Comment;
import com.ga.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostDao postDao;

    @Autowired
    JwtUtil jwtUtil;

    @Override
    public Post addPost(Post post, String token) {
        token = JwtUtil.extractToken(token);
        String username = jwtUtil.getUsernameFromToken(token);
        return postDao.addPost(post, username);

    }

    @Override
    public List<Post> listPost() {
        return postDao.listPost();
    }

    @Override
    public List<Post> listPostByUser(String token) {
        String username = jwtUtil.getUsernameFromToken(token);
        return postDao.listPostByUser(username);
    }

    @Override
    public Comment addComment(Long postId, Comment comment, String token){
        String username = jwtUtil.getUsernameFromToken(token);
        return postDao.addComment(postId, comment, username);
    };

}
