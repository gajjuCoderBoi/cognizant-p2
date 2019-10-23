package com.ga.controller;

        import com.ga.entity.Post;
        import com.ga.service.PostService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping
    public Post addPost(@RequestBody Post post) {
                return postService.addPost(post);
    }

    @GetMapping("/list")
    public Iterable<Post> listPost() {
        return postService.listPost();
    }

    @GetMapping({"/{postId}/comment"})
    public Post addComment(@PathVariable long postId, @RequestBody String commentText) {
        return postService.addComment(postId, commentText);
    }

}

//    @PutMapping("/{username}/song/{songId}")
//    public User addSong(@PathVariable String username, @PathVariable long songId) {
//        return userService.addSong(username, songId);
//    }