package com.ga.service;

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

    @Override
    public Post addPost(Post post) {
        return postDao.addPost(post);
    }

    @Override
    public List<Post> listPost() {
        return postDao.listPost();
    }

    @Override
    public Post addComment(Long postId, Comment comment){
        return postDao.addComment(postId, comment);
    };

}
