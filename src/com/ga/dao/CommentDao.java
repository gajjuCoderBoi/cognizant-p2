package com.ga.dao;

import java.util.List;
import com.ga.entity.Comment;


public interface CommentDao {

        public Comment addComment(Comment comment);
        public List<Comment> listComments();

}

//        public Comment getCommentById(Long commentId);
//        public Comment editComment(Comment comment);
//        public Comment deleteComment(Long commentId);
