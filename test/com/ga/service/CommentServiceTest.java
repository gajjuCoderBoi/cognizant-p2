package com.ga.service;

import com.ga.config.JwtUtil;
import com.ga.dao.CommentDao;
import com.ga.entity.Comment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CommentServiceTest {

    @InjectMocks
    CommentServiceImpl commentService;

    @Mock
    CommentDao commentDao;

    @InjectMocks
    private Comment comment;

    @Mock
    JwtUtil jwtUtil;

    private List<Comment> dummyCommentList;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Before
    public void initializeDummies() {
        comment.setCommentId(1l);
        comment.setCommentText("dummy Text");

        dummyCommentList = Arrays.asList(
                new Comment("comment 1"),
                new Comment("comment 2")
        );

    }


//    @Test
//    public void createComment_Comment_Success() {
//        when(commentDao.createComment(anyLong(), any())).thenReturn(comment);
//
//        Comment comment = commentDao.createComment(1l, this.comment);
//
//        assertNotNull(comment);
//    }

    private void listCommentsByUser_List_Success() {
        /*List<Comment> expected =Arrays.asList(
                new Comment("comment 1"),
                new Comment("comment 2")
        );*/

        when(commentDao.listCommentsByUser(anyString())).thenReturn(dummyCommentList);

        List<Comment> actual = commentDao.listCommentsByUser("username");

        assertNotNull(actual);

    }

    private void listComments_List_Success() {
        List<Comment> expected = Arrays.asList(
                new Comment("comment 1"),
                new Comment("comment 2")
        );

        when(commentDao.listComments()).thenReturn(expected);

        List<Comment> actual = commentDao.listComments();

        assertArrayEquals(expected.toArray(), actual.toArray());

    }

    private void updateComment_Comment_Success() {
        when(commentDao.updateComment(anyLong(), any(), anyString())).thenReturn(comment);

        Comment comment = commentDao.updateComment(1l, this.comment, "username");

        assertEquals(this.comment.getCommentText(), comment.getCommentText());
    }

    private void deleteComment_Long_Success() {
        Long expected = 1l;

//        when(jwtUtil.getUsernameFromToken(anyString())).thenReturn("username");
        when(commentDao.deleteComment(anyLong(), anyString())).thenReturn(comment.getCommentId());

        Long actual = commentDao.deleteComment(comment.getCommentId(), "username");

        assertEquals(expected, actual);

    }

    @Test
    public void listCommentsByUser() {
        listCommentsByUser_List_Success();
    }

    @Test
    public void listComments() {
        listComments_List_Success();
    }

    @Test
    public void updateComment() {
        updateComment_Comment_Success();
    }

    @Test
    public void deleteComment() {
        deleteComment_Long_Success();
    }
}