package com.ga.controller;

import com.ga.entity.Comment;
import com.ga.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {

        @Autowired
        CommentService commentService;

        @PostMapping
        public Comment createComment(Long postId, @RequestBody Comment comment) {
                return commentService.createComment(postId ,comment);
        }

        @GetMapping("/list")
        public Iterable<Comment> listComments() {
                return commentService.listComments();
        }

}

