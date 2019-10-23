package com.ga.dao;

import com.ga.entity.Comment;
import com.ga.entity.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//import java.util.List;

@Repository
public class PostDaoImpl implements PostDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Post addPost(Post post) {

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            session.save(post);
            session.getTransaction().commit();
        } finally {
            session.close();
        }

        return post;

    }

    @Override
    public List<Post> listPost() {
        List<Post> posts = null;

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            posts = session.createQuery("FROM Post").getResultList();
        } finally {
            session.close();
        }

        return posts;
    }

    @Override
    public Post addComment(Long postId, String commentText) {
        Comment comment = null;
        Post post = null;

        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();

            post = (Post)session.createQuery("FROM Post p WHERE p.post_id = '" + postId + "'").uniqueResult();
            comment = session.get(Comment.class, commentText);
            post.addComments(comment);

            session.update(post);

            session.getTransaction().commit();
        } finally {
            session.close();
        }

        return post;
    }

    @Override
    public Post getPostById(Long postId) {
        Post post = null;

        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();

            post = (Post)session.createQuery("From Post p WHERE p.post_id = '" + postId + "'").uniqueResult();
        } finally {
            session.close();
        }
        return post;
    }


}


//    @Override
//    public Post getPostById(Long postId) {
//        return null;
//    }
//
//    @Override
//    public Post editPost(Post post) {
//        return null;
//    }
//
//    @Override
//    public Post deletePost(Long postId) {
//        return null;
//    }
