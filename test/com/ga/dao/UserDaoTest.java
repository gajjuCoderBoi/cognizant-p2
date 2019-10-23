package com.ga.dao;

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

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class UserDaoTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

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
        userRole.setRoleId(1L);
        userRole.setName("ROLE_ADMIN");

        user2.setUserId(1L);
        user2.setUsername("batman");
        user2.setPassword("robin");
        //user2.setUserRole(userRole);


        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.getTransaction()).thenReturn(transaction);

    }

    @Test
    public void listUsers() {

    }

    @Test
    public void signup() {
        signup_User_Success();
    }


    @Test
    public void login() {
        singin_User_Success();
    }


    @Test
    public void update() {
        when(session.get(User.class,"kjh")).thenReturn(user2);

        User user = userDao.update(user2, user2.getUsername());
    }

    @Test
    public void delete() {
    }

    @Test
    public void getUserByUsername() {
    }



    private void signup_User_Success() {
        when(userRoleDao.getRoleByName(anyString())).thenReturn(userRole);

        User savedUser = userDao.signup(user2);

        assertNotNull("Test returned null object, expected non-null", savedUser);
        assertEquals(savedUser, user2);
    }

    private void singin_User_Success() {
        when(session.createQuery(anyString()).getSingleResult()).thenReturn(user2);
        User savedUser = userDao.login(user2);
        assertEquals(savedUser, user2);

    }
}