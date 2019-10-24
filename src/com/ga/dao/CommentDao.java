package com.ga.dao;

import java.util.List;
import com.ga.entity.Comment;


public interface CommentDao {

        public Comment createComment(Long postId , Comment comment);
        public List<Comment> listComments();

        public List<Comment> listCommentsByUser(String username);

        public List<Comment> listCommentsByPost(Long postId);

        public Comment getCommentById(Long commentId);

        public Comment updateComment(Long commentId, Comment comment, String username);


}

//        public Comment getCommentById(Long commentId);
//        public Comment editComment(Comment comment);
//        public Comment deleteComment(Long commentId);
