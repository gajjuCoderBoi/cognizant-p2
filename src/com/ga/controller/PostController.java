package com.ga.controller;

        import com.ga.entity.Post;
        import com.ga.service.PostService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

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

}