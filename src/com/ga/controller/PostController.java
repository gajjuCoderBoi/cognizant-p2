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

    @GetMapping("/{username}")
    public Iterable<Post> listPostByUser(@PathVariable String username) {
        return postService.listPost(username);
    }

    @PostMapping({"/{postId}/comment/"})
    public Post addComment(@PathVariable Long postId, @RequestBody Comment comment) {
        return postService.addComment(postId, comment);
    }

}

//    @PutMapping("/{username}/song/{songId}")
//    public User addSong(@PathVariable String username, @PathVariable long songId) {
//        return userService.addSong(username, songId);
//    }