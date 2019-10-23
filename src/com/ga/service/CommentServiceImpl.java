package com.ga.service;

import com.ga.dao.CommentDao;
import com.ga.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao commentDao;


    @Override
    public Comment createComment(Long postId , Comment comment) {
        return commentDao.createComment(postId, comment);
    }

    @Override
    public List<Comment> listComments() {
        return commentDao.listComments();
    }

}
