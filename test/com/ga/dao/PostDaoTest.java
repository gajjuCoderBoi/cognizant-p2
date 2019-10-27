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
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PostDaoTest {

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
    private CommentDaoImpl commentDao;

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
    private PostDaoImpl postDao;

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
        post2.setUser(user2);

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
    public void addPost() {
        addPost_Post_Success();
    }

    @Test
    public void listPost() {
        listPost_Post_Success();
    }

    @Test
    public void listPostByUser() {
        listPostByUser_Post_Success();
    }

    @Test
    public void addComment() {
        addComment_Post_Success();
    }

    @Test
    public void getPostById() {
        getPostById_Post_Success();
    }

    @Test
    public void updatePost() {
        updatePost_Post_Success();
    }

    @Test
    public void deletePost() {
        deletePost_Post_Success();
    }

    private void addPost_Post_Success(){
        when(userDao.getUserByUsername(anyString())).thenReturn(user2);
        Post savedPost = postDao.addPost(post2, "batman");
        assertNotNull("Test returned null object, expected non-null", savedPost);
        assertEquals(savedPost, post2);
    };

    private void listPost_Post_Success(){
        when(session.createQuery(anyString()).getResultList()).thenReturn(samplePostList);
        List <Post> savedPost = postDao.listPost();
        assertNotNull("Test returned null object, expect non-null", savedPost);
        assertEquals(savedPost, samplePostList);

    };

    private void listPostByUser_Post_Success(){
        when(userDao.getUserByUsername(anyString())).thenReturn(user2);
        List<Post> savedPost = user2.getPosts();
        assertNotNull("Test returned null object, expect non-null", savedPost);
        assertEquals(savedPost, samplePostList);
    };

    private void addComment_Post_Success(){
        when(post.getPostId()).thenReturn(post2.getPostId());
        when(userDao.getUserByUsername(anyString())).thenReturn(user2);
        Comment savedComment = postDao.addComment(post2.getPostId(), comment2, user2.getUsername());
        assertNotNull("Test returned null object, expect non-null", savedComment);
        assertEquals(savedComment, comment2);
    };

    private void getPostById_Post_Success(){
        when(session.get(Post.class, post2.getPostId())).thenReturn(post2);
        Post savedPost = session.get(Post.class, post2.getPostId());
        assertNotNull("Test returned null object, expected non-null", savedPost);
        assertEquals(savedPost, post2);
    };

//    null pointer exception on line 192, in postDaoTest
//    postDaoImpl Line 115
//    if (post1.getUser().getUsername().equals(username)) {
//        post1.setPostText(post.getPostText());
//    } else {
//        return null;
//    }

    private void updatePost_Post_Success(){
        when(userDao.getUserByUsername(anyString())).thenReturn(user2);
        Long savedPostId = post2.getPostId();
        Post savedPost = postDao.updatePost(post2.getPostId(), post2, user2.getUsername());
        assertNotNull("Test returned null object, expect non-null", savedPost);
        assertEquals(savedPost, post2);

    };

    //    null pointer exception on line 209, in postDaoTest
//    postDaoImpl Line 135
//    if (!(post1.getUser().getUsername().equals(username))) {
//        return null;
//    }

    private void deletePost_Post_Success(){
        when(userDao.getUserByUsername(anyString())).thenReturn(user2);
        Long savedPostId = post2.getPostId();
        Long savedPost = postDao.deletePost(post2.getPostId(), user2.getUsername());
        assertNotNull("Test returned null object, expect non-null", savedPost);
        assertEquals(savedPost, post2);

    }


}