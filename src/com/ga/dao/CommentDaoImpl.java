package com.ga.dao;

import com.ga.entity.Comment;
import com.ga.entity.Post;
import com.ga.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao {

    @Autowired
    PostDao postDao;

    @Autowired
    UserDao userDao;

    @Autowired
    SessionFactory sessionFactory;



        @Override
    public List<Comment> listComments() {
        List<Comment> comments = null;

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            comments = session.createQuery("FROM Comment").getResultList();
        } finally {
            session.close();
        }

        return comments;

    }

    @Override
    public List<Comment> listCommentsByUser(String username) {
        User user = userDao.getUserByUsername(username);
        return user.getComments();
    }

    @Override
    public List<Comment> listCommentsByPost(Long postId) {
        Post post = postDao.getPostById(postId);
        return post.getComments();
    }

    @Override
    public Comment getCommentById(Long commentId) {
        Comment comment = null;

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            comment = session.get(Comment.class, commentId);
        } finally {
            session.close();
        }
        return comment;
    }

    @Override
    public Comment updateComment(Long commentId, Comment comment, String username) {
        User user = userDao.getUserByUsername(username);
        Comment comment1 = getCommentById(commentId);
        if(comment1.getUser().getUsername().equals(username)) {
            comment1.setCommentText(comment.getCommentText());
        } else {
            return null;
        }
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.update(comment1);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
        return comment1;
        }

    @Override
    public Long deleteComment(Long commentId, String username) {
        User user = userDao.getUserByUsername(username);
        Comment comment1 = getCommentById(commentId);
        if (!(comment1.getUser().getUsername().equals(username))) {
            return null;
        }
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.delete(comment1);
            session.getTransaction().commit();
        } finally {
            session.close();
        }

        return comment1.getCommentId();
    }

}