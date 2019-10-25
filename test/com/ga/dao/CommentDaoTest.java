package com.ga.dao;

import com.ga.entity.Post;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import org.hibernate.query.Query;

import com.ga.entity.Comment;


public class CommentDaoTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private Comment comment;

    @InjectMocks
    private UserDaoImpl userDao;

    @InjectMocks
    private Post post;

    @InjectMocks
    private PostDaoImpl postDao;

    @Mock
    private SessionFactory sessionFactory;

    @Mock
    Session session;

    @Mock
    Transaction transaction;

    @Mock
    Query<Comment> query;

    @Before
    public void init() {
        post.setPostId((long) 1);

        comment.setCommentText("Comment Text");
//        userRole.setName("ROLE_ADMIN");
//
//        user.setUserId(1L);
//        user.setUsername("batman");
//        user.setPassword("robin");
//        user.setUserRole(userRole);

        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.getTransaction()).thenReturn(transaction);
    }

    @Test
    public void createComment() {
        //TODO
    }

//    @Test
//    public void createComment_Comment_Success() {
//        when(post.getPostId(anyLong())).thenReturn(post.getPostId(anyLong()));
//
//        Comment savedComment = postDao.addComment(postId,comment, userDao.getUserByUsername());
//
//    }

//    public void signup_User_Success() {
//        when(userRoleDao.getRole(anyString())).thenReturn(userRole);
//
//        User savedUser = userDao.signup(user);
//
//        assertNotNull("Test returned null object, expected non-null", savedUser);
//        assertEquals(savedUser, user);
//    }

    @Test
    public void listComments() {
        //TODO
    }

    @Test
    public void listCommentsByUser() {
        // TODO
    }

    @Test
    public void listCommentsByPost() {
        // TODO
    }

    @Test
    public void getCommentById() {
        // TODO
    }

    @Test
    public void updateComment() {
        // TODO
    }
}