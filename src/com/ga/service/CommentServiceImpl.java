package com.ga.service;

import com.ga.config.JwtUtil;
import com.ga.dao.CommentDao;
import com.ga.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao commentDao;

    @Autowired
    JwtUtil jwtUtil;


    @Override
    public Comment createComment(Long postId , Comment comment) {
        return commentDao.createComment(postId, comment);
    }

    @Override
    public List<Comment> listCommentsByUser(String token) {
        String username = jwtUtil.getUsernameFromToken(token);
        return commentDao.listCommentsByUser(username);
    }

    @Override
    public List<Comment> listComments() {
        return commentDao.listComments();
    }

    @Override
    public Comment updateComment(Long commentId, Comment comment, String token) {
        String username = jwtUtil.getUsernameFromToken(token);
        return commentDao.updateComment(commentId, comment, username);
    }

    @Override
    public Long deleteComment(Long commentId, String token) {
        String username = jwtUtil.getUsernameFromToken(token);
        return commentDao.deleteComment(commentId, username);
    }

}

//    @Override
//    public Long deletePost(Long postId, String token) {
//        String username = jwtUtil.getUsernameFromToken(token);
//        return postDao.deletePost(postId, username);
//    }