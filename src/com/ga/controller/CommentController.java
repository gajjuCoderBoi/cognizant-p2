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

//        does not seem to work now

        @GetMapping("/")
        public Iterable<Comment> listCommentsByUser(@RequestHeader("Authorization") String token) {
                return commentService.listCommentsByUser(token);
        }

        @GetMapping("/list")
        public Iterable<Comment> listComments() {
                return commentService.listComments();
        }

       @PutMapping("/{commentId}")
        public ResponseEntity<?> updateComment(@PathVariable Long commentId, @RequestBody Comment comment, @RequestHeader("Authorization") String token){
                Comment comment1 = commentService.updateComment(commentId, comment, token);
                return comment1!=null ?
                        ResponseEntity.ok(comment1) :
                        new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        @DeleteMapping("/{commentId}")
        public ResponseEntity<?> deleteComment(@PathVariable Long commentId, @RequestHeader("Authorization") String token){
                Long comment1 = commentService.deleteComment(commentId, token);
                return comment1!=null ?
                        ResponseEntity.ok(comment1) :
                        new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

}

