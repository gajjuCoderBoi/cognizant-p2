package com.ga.dao;

import com.ga.entity.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao {

    @Autowired
    private SessionFactory sessionFactory;

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

//    List<Song> songs = null;
//
//    Session session = sessionFactory.getCurrentSession();
//
//		try {
//        session.beginTransaction();
//
//        songs = session.createQuery("FROM Song").getResultList();
//    } finally {
//        session.close();
//    }
//
//		return songs;
//}

    @Override
    public Comment getCommentById(Long commentId) {
        return null;
    }

    @Override
    public Comment addComment(Comment comment) {
        return null;
    }

    @Override
    public Comment editComment(Comment comment) {
        return null;
    }

    @Override
    public Comment deleteComment(Long commentId) {
        return null;
    }
}
