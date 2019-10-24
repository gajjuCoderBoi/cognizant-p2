package com.ga.controller;

import com.ga.entity.Comment;
import com.ga.entity.Post;
import com.ga.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

        @Autowired
        CommentService commentService;

        @PostMapping
        public Comment createComment(Long postId, @RequestBody Comment comment) {
                return commentService.createComment(postId ,comment);
        }

        @GetMapping("/")
        public Iterable<Comment> listCommentsByUser(@RequestHeader("Authorization") String token) {
                return commentService.listCommentsByUser(token);
        }

        @GetMapping("/list")
        public Iterable<Comment> listComments() {
                return commentService.listComments();
        }


}

