package com.ga.service;

import com.ga.entity.Comment;

import java.util.List;

public interface CommentService {

    public List<Comment> listComments();
    public Comment getCommentById(Long commentId);
    public Comment addComment(Comment comment);
    public Comment editComment(Comment comment);
    public Comment deleteComment(Long commentId);

}
