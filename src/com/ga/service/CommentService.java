package com.ga.service;

import com.ga.config.JwtUtil;
import com.ga.entity.Comment;

import java.util.List;

public interface CommentService {

    public Comment createComment(Long postId , Comment comment);

    public List<Comment> listCommentsByUser(String token);

    public List<Comment> listComments();

    public Comment updateComment(Long commentId, Comment comment, String token);

}

//    public Comment getCommentById(Long commentId);
//    public Comment editComment(Comment comment);
//    public Comment deleteComment(Long commentId);
