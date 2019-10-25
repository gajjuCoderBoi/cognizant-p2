package com.ga.dao;

import com.ga.entity.Comment;
import com.ga.entity.Post;
import com.ga.entity.User;
import com.ga.entity.UserRole;
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
import static org.mockito.Mockito.when;

public class UserDaoTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    private MockMvc mockMvc;

    private List<User> sampleUserList;

    @InjectMocks
    private UserRole userRole;

    @InjectMocks
    private UserDaoImpl userDao;

    @Mock
    private UserRoleDao userRoleDao;

    @Mock
    private SessionFactory sessionFactory;

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    Session session;

    @Mock
    private Transaction transaction;

    @Mock
    private Query<User> query;

    @InjectMocks
    private User user2;

    @Mock
    private User user;


    @Before
    public void initDummyUser() {
        user2.setUserId(1L);
        user2.setUsername("batman");
        user2.setPassword("robin");

        mockMvc = MockMvcBuilders.standaloneSetup(userDao).build();

        sampleUserList = Arrays.asList(
                new User(
                        "batman",
                        "robin"
                )
        );

        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.getTransaction()).thenReturn(transaction);
        when(session.createQuery(anyString())).thenReturn(query);
    }

    @Test
    public void listUsers() {
        listUsers_User_Success();
    }

    @Test
    public void signup() {
        signup_User_Success();
    }


    @Test
    public void login() {
        signin_User_Success();
    }


    @Test
    public void update() {
        update_User_Success();
    }

//    @Test
//    public void delete() {
//        when(session.get(User.class, "123")).thenReturn(user2);
//        User user = userDao.delete(user2.getUserId());
//        assertEquals(user, user2);
//        assertNotNull("Test returned null object, expected non-null", user);
//    }

    @Test
    public void getUserByUsername() {
        getUserByUsername_User_Success();
    }

    private void listUsers_User_Success(){
        when(userDao.listUsers()).thenReturn(sampleUserList);
        List<User> users = userDao.listUsers();
        assertNotNull("Test returned null object, expected non-null", users);
        assertEquals(users, sampleUserList);
    };


    private void signup_User_Success() {
        User savedUser = userDao.signup(user2);
        assertNotNull("Test returned null object, expected non-null", savedUser);
        assertEquals(savedUser, user2);
    }

    private void signin_User_Success() {
        when(session.createQuery(anyString()).getSingleResult()).thenReturn(user2);
        User savedUser = userDao.login(user2);
        assertNotNull("Test returned null object, expected non-null", savedUser);
        assertEquals(savedUser, user2);

    }

    private void update_User_Success() {
        when(query.uniqueResult()).thenReturn(user2);
        user2.setPassword("bat");
        User savedUser = userDao.update(user2, user2.getUsername());
//        savedUser.setPassword(savedUser.getPassword());
        assertNotNull("Test returned null object, expect non-null", savedUser);
        assertEquals(savedUser.getPassword(), user2.getPassword());
    }

    private void getUserByUsername_User_Success() {
        when(query.uniqueResult()).thenReturn(user2);
        User savedUser = userDao.getUserByUsername(user2.getUsername());
        assertNotNull("Test returned null object, expect non-null", savedUser);
        assertEquals(savedUser, user2);
    }
}