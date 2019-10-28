package com.ga.dao;

import com.ga.entity.Comment;
import com.ga.entity.Post;
import com.ga.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.*;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class CommentDaoTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    private MockMvc mockMvc;

    private List<Comment> sampleCommentList;

    private List<Post> samplePostList;

    @Mock
    private SessionFactory sessionFactory;

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    Session session;

    @Mock
    Transaction transaction;

    @Mock
    Query<Comment> query;

    @Mock
    private PostDaoImpl postDao;

    @Mock
    private UserDao userDao;

    @Mock
    private Comment comment;

    @Mock
    private Post post;

    @Mock
    private User user;

    @InjectMocks
    private Comment dummyComment;

    @InjectMocks
    private Post dummyPost;

    @InjectMocks
    private User dummyUser;

    @Spy
    @InjectMocks
    private CommentDaoImpl commentDaoInjectMock;

    @Mock
    private CommentDaoImpl commentDaoMockOnly;

    @Before
    public void initDummyData() {
        dummyUser.setUserId(1L);
        dummyUser.setUsername("batman");
        dummyUser.setPassword("robin");

        dummyUser.setPosts(samplePostList);
        dummyUser.setComments(sampleCommentList);

        dummyComment.setCommentId(1L);
        dummyComment.setCommentText("Custom comment text.");
        dummyComment.setUser(dummyUser);
        dummyComment.setPost(dummyPost);

        dummyPost.setPostId(1L);
        dummyPost.setTitle("Custom post title");
        dummyPost.setPostText("Custom post text.");

        dummyPost.setComments(sampleCommentList);

        sampleCommentList = Arrays.asList(
                new Comment(
                        "Custom comment text"
                )
        );

        samplePostList = Arrays.asList(
                new Post(
                        1L,
                        "Custom Post Title",
                        "Custom Post Text"
                )
        );


        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.getTransaction()).thenReturn(transaction);
        when(session.createQuery(anyString())).thenReturn(query);
    }

    @Test
    public void listCommentsByUser() {
        listCommentsByUser_Comment_Success();
    }

    @Test
    public void listCommentsByPost() {
        listCommentsByPost_Comment_Success();
    }

    @Test
    public void getCommentById() {
        getCommentById_Comment_Success();
    }

    @Test
    public void updateComment() {
        updateComment_Comment_Success();
    }

    @Test
    public void deleteComment() {
        deleteComment_Comment_Success();
    }

    private void listCommentsByUser_Comment_Success() {
        when(userDao.getUserByUsername(anyString())).thenReturn(dummyUser);
        when(user.getComments()).thenReturn(sampleCommentList);
        List<Comment> savedComments = user.getComments();
        assertNotNull("Test returned null object, expected non-null", savedComments);
        assertEquals(savedComments, sampleCommentList);
    }

    private void listCommentsByPost_Comment_Success() {
        when(post.getComments()).thenReturn(sampleCommentList);
        List<Comment> savedComments = post.getComments();
        assertNotNull("Test returned null object, expected non-null", savedComments);
        assertEquals(savedComments, sampleCommentList);
    }

    ;

    private void getCommentById_Comment_Success() {
        when(session.get(Comment.class, dummyComment.getCommentId())).thenReturn(dummyComment);
        Comment savedComment = session.get(Comment.class, dummyComment.getCommentId());
        assertNotNull("Test returned null object, expected non-null", savedComment);
        assertEquals(savedComment.getCommentId(), dummyComment.getCommentId());
    }

    ;

    //    null pointer exception on line 174, in commentDaoTest
//    commentDaoImpl Line 76
//if(comment1.getUser().getUsername().equals(username)) {
//        comment1.setCommentText(comment.getCommentText());
//    } else {
//        return null;
//    }

    private void updateComment_Comment_Success() {
        when(userDao.getUserByUsername(anyString())).thenReturn(dummyUser);
        doReturn(dummyComment).when(commentDaoInjectMock).getCommentById(anyLong());
        when(comment.getCommentId()).thenReturn(dummyComment.getCommentId());
        Comment savedComment = commentDaoInjectMock.updateComment(1L, dummyComment, dummyUser.getUsername());
        assertNotNull("Test returned null object, expected non-null", savedComment);
        assertEquals(savedComment.getCommentId(), dummyComment.getCommentId());
    }

    
    private void deleteComment_Comment_Success() {
        when(userDao.getUserByUsername(any())).thenReturn(dummyUser);
        when(comment.getCommentId()).thenReturn(dummyComment.getCommentId());
        doReturn(dummyComment).when(commentDaoInjectMock).getCommentById(anyLong());
        Long savedCommentId = commentDaoInjectMock.deleteComment(1L, dummyUser.getUsername());
        assertNotNull("Test returned null object, expected non-null", savedCommentId);
        assertEquals(savedCommentId, dummyComment.getCommentId());
    }

}