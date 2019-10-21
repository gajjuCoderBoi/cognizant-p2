package com.ga.dao;

import com.ga.entity.Post;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDaoImpl implements PostDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Post> listPost() {
        return null;
    }

    @Override
    public Post getPostById(Long postId) {
        return null;
    }

    @Override
    public Post addPost(Post post) {
        return null;
    }

    @Override
    public Post editPost(Post post) {
        return null;
    }

    @Override
    public Post deletePost(Long postId) {
        return null;
    }
}
