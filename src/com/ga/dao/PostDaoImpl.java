package com.ga.dao;

import com.ga.entity.Comment;
import com.ga.entity.Post;
import com.ga.entity.User;
import javafx.geometry.Pos;
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
        User user = userDao.getUserByUsername(username);
        return user.getPosts();
    }

    @Override
    public Post addComment(Long postId, Comment comment) {
        //Comment comment = null;
        Post post = null;

        Session session = sessionFactory.getCurrentSession();

        try {
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

        try {
            session.beginTransaction();
            post = session.get(Post.class, postId);
            //post = (Post) session.createQuery("From Post p WHERE p.post_id = '" + postId + "'").uniqueResult();
        } finally {
            session.close();
        }
        return post;
    }

    @Override
    public Post updatePost(Long postId, Post post, String username) {
        User user = userDao.getUserByUsername(username);
        Post post1 = getPostById(postId);
        if (post1.getUser().getUsername().equals(username)) {
            post1.setPostText(post.getPostText());
        } else {
            return null;
        }
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.update(post1);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
        return post1;
    }

    @Override
    public Long deletePost(Long postId, String username) {
        User user = userDao.getUserByUsername(username);
        Post post1 = getPostById(postId);
        if (!(post1.getUser().getUsername().equals(username))) {
            return null;
        }
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.delete(post1);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
        return post1.getPostId();
    }


}