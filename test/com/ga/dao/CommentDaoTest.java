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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
    private Comment comment2;

    @InjectMocks
    private Post post2;

    @InjectMocks
    private User user2;


    @InjectMocks
    private CommentDaoImpl commentDao;

    @Before
    public void initDummyData() {
        user2.setUserId(1L);
        user2.setUsername("batman");
        user2.setPassword("robin");

        user2.setPosts(samplePostList);
        user2.setComments(sampleCommentList);

        comment2.setCommentId(1L);
        comment2.setCommentText("Custom comment text.");

        post2.setPostId(1L);
        post2.setTitle("Custom post title");
        post2.setPostText("Custom post text.");

        post2.setComments(sampleCommentList);

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
    public void deleteComment(){
        deleteComment_Comment_Success();
    }

    private void listCommentsByUser_Comment_Success(){
        when(userDao.getUserByUsername(anyString())).thenReturn(user2);
        when(user.getComments()).thenReturn(sampleCommentList);
        List<Comment> savedComments = user.getComments();
        assertNotNull("Test returned null object, expected non-null", savedComments);
        assertEquals(savedComments, sampleCommentList);
    }

    private void listCommentsByPost_Comment_Success(){
        when(post.getComments()).thenReturn(sampleCommentList);
        List<Comment> savedComments = post.getComments();
        assertNotNull("Test returned null object, expected non-null", savedComments);
        assertEquals(savedComments, sampleCommentList);
    };

    private void getCommentById_Comment_Success(){
        when(session.get(Comment.class, comment2.getCommentId())).thenReturn(comment2);
        Comment savedComment = session.get(Comment.class, comment2.getCommentId());
        assertNotNull("Test returned null object, expected non-null", savedComment);
        assertEquals(savedComment.getCommentId(), comment2.getCommentId());
    };

    private void updateComment_Comment_Success(){
//        when(userDao.getUserByUsername(anyString())).thenReturn(user2);
//        when(comment.getCommentId()).thenReturn(comment2.getCommentId());
//        when(comment.getUser().getUsername().equals(anyString())).thenReturn(true);
//        when(comment.getCommentText()).thenReturn(comment2.getCommentText());
//        Comment savedComment = commentDao.updateComment(1L, comment2, "batman");
//        assertNotNull("Test returned null object, expected non-null", savedComment);
//        assertEquals(savedComment.getCommentId(), comment2.getCommentId());
        //TODO
    };


    private void deleteComment_Comment_Success(){
        when(userDao.getUserByUsername(anyString())).thenReturn(user2);
        when(comment.getCommentId()).thenReturn(comment2.getCommentId());
        when(session.delete(anyLong()))
    };

}