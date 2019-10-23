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
    public Comment createComment(Long postId , Comment comment) {
            Post post = postDao.getPostById(postId);

            Session session = sessionFactory.getCurrentSession();

            try {
                session.beginTransaction();

                session.save(comment);
                post.addComments(comment);
                session.update(post);

                session.getTransaction().commit();
            } finally {
                session.close();
            }

            return comment;
        }

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

}

//    @Override
//    public List<Post> listPostByUser(String username) {
//
//
//        User user = userDao.getUserByUsername(username);
//        return user.getPosts();
//    }

//
//    @Override
//    public Comment editComment(Comment comment) {
//        return null;
//    }
//
//    @Override
//    public Comment deleteComment(Long commentId) {
//        return null;
//    }
