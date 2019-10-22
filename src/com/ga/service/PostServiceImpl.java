package com.ga.service;

import com.ga.dao.PostDao;
import com.ga.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostDao postDao;

    @Override
    public Post addPost(Post post) {
        return postDao.addPost(post);
    }

}
