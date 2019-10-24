package com.ga.controller;

import com.ga.entity.Comment;
import com.ga.entity.Post;
import com.ga.service.CommentService;
import com.ga.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    PostService postService;

    @GetMapping
    public Iterable<Comment> listComments() {
        return commentService.listComments();
    }

    @GetMapping("/list")
    public Iterable<Comment> listCommentsByUser(@RequestHeader("Authorization") String token) {
        return commentService.listCommentsByUser(token);
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<?> updateComment(@PathVariable Long commentId, @RequestBody Comment comment, @RequestHeader("Authorization") String token) {
        Comment comment1 = commentService.updateComment(commentId, comment, token);
        return comment1 != null ?
                ResponseEntity.ok(comment1) :
                new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable Long commentId, @RequestHeader("Authorization") String token) {
        Long comment1 = commentService.deleteComment(commentId, token);
        return comment1 != null ?
                ResponseEntity.ok(comment1) :
                new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping({"/{postId}"})
    public Comment addComment(@PathVariable Long postId, @RequestBody Comment comment, @RequestHeader("Authorization") String token) {
        return postService.addComment(postId, comment, token);
    }

}

