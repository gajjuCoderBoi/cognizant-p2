package com.ga.service;

import com.ga.config.JwtUtil;
import com.ga.entity.Comment;

import java.util.List;

public interface CommentService {


    public List<Comment> listCommentsByUser(String token);

    public List<Comment> listComments();

    public Comment updateComment(Long commentId, Comment comment, String token);

    public Long deleteComment(Long commentId, String token);
}
