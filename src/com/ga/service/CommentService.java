package com.ga.service;

import com.ga.entity.Comment;

import java.util.List;

public interface CommentService {

    public Comment addComment(Long postId , Comment comment);

    public List<Comment> listComments();

}

//    public Comment getCommentById(Long commentId);
//    public Comment editComment(Comment comment);
//    public Comment deleteComment(Long commentId);
