package com.ga.dao;

import com.ga.entity.Comment;
import com.ga.entity.Post;
import com.ga.entity.User;
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

    @Autowired
    UserDao userDao;


    @Override
    public Post addPost(Post post, String username) {
        User user = userDao.getUserByUsername(username);
        Session session = sessionFactory.getCurrentSession();
        post.setUser(user);
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
    public List<Post> listPostByUser(String username) {
        return userDao.listUserSongs(username);
    }

    @Override
    public Post addComment(Long postId, Comment comment) {
        //Comment comment = null;
        Post post = null;

        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();
            post = session.get(Post.class, postId);
            comment.setPost(post);
            session.save(comment);
            /*post = (Post)session.createQuery("FROM Post p WHERE p.postId = '" + postId + "'").uniqueResult();
            comment = session.get(Comment.class, commentId);
            post.addComments(comment);

            session.update(post);*/

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
