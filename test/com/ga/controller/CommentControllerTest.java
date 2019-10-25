package com.ga.controller;

import com.ga.entity.Comment;
import com.ga.entity.Post;
import com.ga.entity.User;
import com.ga.service.CommentService;
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

import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class CommentControllerTest {

    private MockMvc mockMvc;

    private Comment sampleComment;

    private List<Comment> sampleCommentList;

    @InjectMocks
    private CommentController commentController;

    @Mock
    private CommentService commentService;

    @Mock
    private PostService postService;

    @Before
    public void init(){
        mockMvc = MockMvcBuilders.standaloneSetup(commentController).build();
        sampleComment = new Comment(
                1L,
                "Some edited text by might",
                new User("might", null),
                new Post(1L, "1 title for my post", null, null, null)
        );

        sampleCommentList = Arrays.asList(
                new Comment(
                        1L,
                        "Some edited text by might",
                        new User("might", null),
                        new Post(1L, "1 title for my post", null, null, null)
                )
        );
    }

    @Test
    public void addComment_Comment_Success() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/comment/1")
                .header("Authorization", "Bearer 123")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"commentText\" : \"Some edited text by might\"\n" +
                        "}");

        when(postService.addComment(anyLong(), any(), anyString())).thenReturn(sampleComment);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("" +
                        "{\n" +
                        "    \"commentId\": 1,\n" +
                        "    \"commentText\": \"Some edited text by might\",\n" +
                        "    \"username\": \"might\",\n" +
                        "    \"postTitle\": \"1 title for my post\",\n" +
                        "    \"postid\": \"1\"\n" +
                        "}"))
                .andReturn();
    }

    @Test
    public void listCommentsByUser_Comment_Success() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/comment/list")
                .header("Authorization", "Bearer 1234");

        when(commentService.listCommentsByUser(anyString())).thenReturn(sampleCommentList);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("[" +
                        "{\n" +
                        "    \"commentId\": 1,\n" +
                        "    \"commentText\": \"Some edited text by might\",\n" +
                        "    \"username\": \"might\",\n" +
                        "    \"postTitle\": \"1 title for my post\",\n" +
                        "    \"postid\": \"1\"\n" +
                        "}]"))
                .andReturn();
    }

    @Test
    public void listComments() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/comment");

        when(commentService.listComments()).thenReturn(sampleCommentList);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("[" +
                        "{\n" +
                        "    \"commentId\": 1,\n" +
                        "    \"commentText\": \"Some edited text by might\",\n" +
                        "    \"username\": \"might\",\n" +
                        "    \"postTitle\": \"1 title for my post\",\n" +
                        "    \"postid\": \"1\"\n" +
                        "}]"))
                .andReturn();
    }

    @Test
    public void updatePost() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/comment/1")
                .header("Authorization", "Bearer 123")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"commentText\" : \"Some edited text by might\"\n" +
                        "}");

        when(commentService.updateComment(anyLong(), any(), anyString())).thenReturn(sampleComment);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("" +
                        "{\n" +
                        "    \"commentId\": 1,\n" +
                        "    \"commentText\": \"Some edited text by might\",\n" +
                        "    \"username\": \"might\",\n" +
                        "    \"postTitle\": \"1 title for my post\",\n" +
                        "    \"postid\": \"1\"\n" +
                        "}"))
                .andReturn();
    }
}