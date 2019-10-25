package com.ga.controller;

import com.ga.entity.Comment;
import com.ga.entity.Post;
import com.ga.entity.User;
import com.ga.service.PostService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class PostControllerTest {

    private MockMvc mockMvc;

    private Post samplePost;

    private List<Post> samplePostList;

    private List<Comment> sampleCommentList;

    @InjectMocks
    private PostController postController;

    @Mock
    private PostService postService;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(postController).build();
        samplePost = new Post(1L,
                "myUser Post Title",
                "myUser Post Text",
                new User("myUser", "sadfsdaf"),
                null
        );

        samplePostList = Arrays.asList(
                new Post(1L,
                        "1 title for my post",
                        "1 My super important post.",
                        new User("might", "sadfsdaf"),
                        null
                ),
                new Post(2L,
                        "1 title for my post",
                        "1 My super important post.",
                        new User("might", "sadfsdaf"),
                        null
                )
        );

        sampleCommentList = Arrays.asList(
                new Comment(
                        1L,
                        "Super Post Comment",
                        new User("might", "xyz"),
                        new Post(1L, "1 title for my post", null, null, null)
                ),
                new Comment(
                        2L,
                        "Super Re-Edited Comment",
                        new User("might", "xyz"),
                        new Post(1L, "1 title for my post", null, null, null)
                ));
    }

    @Test
    public void addPost_Post_Success() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/post")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer 12345")
                .content("{\n" +
                        "\t\"title\" : \"myUser Post Title\",\n" +
                        "\t\"postText\" : \"myUser Post Text\"\n" +
                        "}");

        when(postService.addPost(any(), anyString())).thenReturn(samplePost);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "    \"postId\": 1,\n" +
                        "    \"title\": \"myUser Post Title\",\n" +
                        "    \"postText\": \"myUser Post Text\",\n" +
                        "    \"userName\": \"myUser\"\n" +
                        "}"))
                .andReturn();

    }

    @Test
    public void listPost_Post_Success() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/post/list");

        when(postService.listPost()).thenReturn(samplePostList);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"postId\": 1,\n" +
                        "        \"title\": \"1 title for my post\",\n" +
                        "        \"postText\": \"1 My super important post.\",\n" +
                        "        \"userName\": \"might\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"postId\": 2,\n" +
                        "        \"title\": \"1 title for my post\",\n" +
                        "        \"postText\": \"1 My super important post.\",\n" +
                        "        \"userName\": \"might\"\n" +
                        "    }\n" +
                        "]"));
    }

    @Test
    public void listPostByUser_Post_Success() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/post/")
                .header("Authorization", "Bearer 123");


        when(postService.listPostByUser(anyString())).thenReturn(samplePostList);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"postId\": 1,\n" +
                        "        \"title\": \"1 title for my post\",\n" +
                        "        \"postText\": \"1 My super important post.\",\n" +
                        "        \"userName\": \"might\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"postId\": 2,\n" +
                        "        \"title\": \"1 title for my post\",\n" +
                        "        \"postText\": \"1 My super important post.\",\n" +
                        "        \"userName\": \"might\"\n" +
                        "    }\n" +
                        "]"));
    }

    @Test
    public void listCommentsByPost_Post_Success() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/post/1/comment/");

        when(postService.listCommentsByPost(anyLong())).thenReturn(sampleCommentList);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"commentId\": 1,\n" +
                        "        \"commentText\": \"Super Post Comment\",\n" +
                        "        \"username\": \"might\",\n" +
                        "        \"postTitle\": \"1 title for my post\",\n" +
                        "        \"postid\": \"1\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"commentId\": 2,\n" +
                        "        \"commentText\": \"Super Re-Edited Comment\",\n" +
                        "        \"username\": \"might\",\n" +
                        "        \"postTitle\": \"1 title for my post\",\n" +
                        "        \"postid\": \"1\"\n" +
                        "    }\n" +
                        "]"));
    }


    @Test
    public void updatePost_Post_Success() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/post/1")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization","Bearer 1234")
                .content("{\n" +
                        "\t\"postText\" : \"my edited post text for might\"\n" +
                        "}");

        when(postService.updatePost(anyLong(), any(), anyString())).thenReturn(samplePost);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "    \"postId\": 1,\n" +
                        "    \"title\": \"myUser Post Title\",\n" +
                        "    \"postText\": \"myUser Post Text\",\n" +
                        "    \"userName\": \"myUser\"\n" +
                        "}"))
                .andReturn();
    }

    @Test
    public void deletePost_Post_Success() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/post/1")
                .header("Authorization", "Bearer 123");

        when(postService.deletePost(anyLong(),anyString())).thenReturn(1L);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());
    }
}