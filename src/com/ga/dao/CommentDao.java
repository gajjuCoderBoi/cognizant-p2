package com.ga.dao;

import com.ga.entity.Comment;

import java.util.List;


public interface CommentDao {
        public List<Comment> listComments();
        public Comment getCommentById(Long commentId);
        public Comment addComment(Comment comment);
        public Comment editComment(Comment comment);
        public Comment deleteComment(Long commentId);
}

//        Do this on posts?
//    public List<Comment> getCommentsByPosts();