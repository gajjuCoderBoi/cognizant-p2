package com.ga.controller;

        import com.ga.entity.Comment;
        import com.ga.entity.Post;
        import com.ga.service.PostService;
        import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping({"/{postId}/comment/"})
    public Comment addComment(@PathVariable Long postId, @RequestBody Comment comment, @RequestHeader("Authorization") String token) {
        return postService.addComment(postId, comment, token);
    }



}