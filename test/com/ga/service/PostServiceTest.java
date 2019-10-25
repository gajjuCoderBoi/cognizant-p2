package com.ga.service;


import com.ga.config.JwtUtil;
import com.ga.dao.CommentDao;
import com.ga.dao.PostDao;
import com.ga.entity.Comment;
import com.ga.entity.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletionException;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PostServiceTest {

    private List<Post> dummyPostList;

    private List<Comment> dummyCommentList;

    private Comment dummyComment;

    @InjectMocks
    private Post dummyPost;

    @InjectMocks
    private PostServiceImpl postService;

    @Mock
    private PostDao postDao;

    @Mock
    private CommentDao commentDao;

    @Mock
    JwtUtil jwtUtil;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Before
    public void initializeDummies() {
        dummyPost.setPostId(1l);
        dummyPost.setTitle("Dummy Post Title");
        dummyPost.setPostText("Dummy Post Text");

        dummyComment = new Comment("comment 1");

        dummyPostList = Arrays.asList(
                new Post(
                        1l,
                        "Dummy Post Title",
                        "Dummy Post Text"),
                new Post(
                        2l,
                        "Dummy 2 Post Title",
                        "Dummy 2 Post Text")
        );

        dummyCommentList = Arrays.asList(
                new Comment("comment 1"),
                new Comment("comment 2")
        );

    }

    @Test
    public void addPost_Post_Success() {
        Post expected = new Post(
                1l,
                "Dummy Post Title",
                "Dummy Post Text");
//        when(jwtUtil.getUsernameFromToken(anyString())).thenReturn("username");
        when(postDao.addPost(any(), anyString())).thenReturn(dummyPost);

        Post actual = postDao.addPost(dummyPost, "username");

        assertEquals(expected.getPostText(), actual.getPostText());

    }

    @Test
    public void listPost_List_Success() {
        when(postDao.listPost()).thenReturn(dummyPostList);

        assertNotNull(postDao.listPost());
    }

    @Test
    public void listPostByUser_List_Success() {
//        when(jwtUtil.getUsernameFromToken(anyString())).thenReturn("username");
        when(postDao.listPostByUser(anyString())).thenReturn(dummyPostList);

        List<Post> actual = postDao.listPostByUser("username");

        assertNotNull(actual);

    }

    @Test
    public void listCommentsByPost_List_SUccess() {
        when(commentDao.listCommentsByPost(anyLong())).thenReturn(dummyCommentList);

        List<Comment> actual = commentDao.listCommentsByPost(1l);

        assertNotNull(actual);
    }

    @Test
    public void addComment_Comment_Success() {
        Comment expected = new Comment("comment 1");
        when(postDao.addComment(anyLong(), any(), anyString())).thenReturn(dummyComment);

        Comment actual = postDao.addComment(1l, dummyComment, "username");

        assertEquals(expected.getCommentText(), actual.getCommentText());

    }

    @Test
    public void updatePost_Post_Success() {
        Post expected = new Post(
                1l,
                "Dummy Post Title",
                "Dummy Post Text");

        when(postDao.updatePost(anyLong(), any(), anyString())).thenReturn(dummyPost);
        Post actual = postDao.updatePost(1l, dummyPost, "username");

        assertEquals(expected.getPostText(), actual.getPostText());
    }

    @Test
    public void deletePost_Long_Success() {
        Post expected = new Post(
                1l,
                "Dummy Post Title",
                "Dummy Post Text");

        when(postDao.deletePost(anyLong(), anyString())).thenReturn(dummyPost.getPostId());

        long actual = postDao.deletePost(1l, "username");

        assertEquals(expected.getPostId(), actual);
    }
}