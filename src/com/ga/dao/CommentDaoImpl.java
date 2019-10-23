package com.ga.dao;

import com.ga.entity.Comment;
import com.ga.entity.Post;
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
    SessionFactory sessionFactory;

    @Override
    public Comment addComment(Long postId , Comment comment) {
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

}

//    @Override
//    public Comment getCommentById(Long commentId) {
//        return null;
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
