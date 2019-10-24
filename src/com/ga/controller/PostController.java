package com.ga.controller;

        import com.ga.entity.Comment;
        import com.ga.entity.Post;
        import com.ga.service.PostService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping
    public Post addPost(@RequestBody Post post, @RequestHeader("Authorization") String token) {
                return postService.addPost(post, token);
    }

    @GetMapping("/list")
    public Iterable<Post> listPost() {
        return postService.listPost();
    }

    @GetMapping("/")
    public Iterable<Post> listPostByUser(@RequestHeader("Authorization") String token) {
        return postService.listPostByUser(token);
    }

    @GetMapping({"/{postId}/comment/"})
    public Iterable<Comment> listCommentsByPost(@PathVariable Long postId) {
        return postService.listCommentsByPost(postId);
    }

    // Depreciated Route.
    /*@PostMapping({"/{postId}/comment/"})
    public Comment addComment(@PathVariable Long postId, @RequestBody Comment comment, @RequestHeader("Authorization") String token) {
        return postService.addComment(postId, comment, token);
    }*/


    @PutMapping("/{postId}")
    public ResponseEntity<?> updatePost(@PathVariable Long postId, @RequestBody Post post, @RequestHeader("Authorization") String token){
        Post post1 = postService.updatePost(postId, post, token);
        return post1!=null ?
                ResponseEntity.ok(post1) :
                new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId, @RequestHeader("Authorization") String token){
        Long post1 = postService.deletePost(postId, token);
        return post1!=null ?
                ResponseEntity.ok(post1) :
                new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

}


