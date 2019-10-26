package com.ga.dao;

import com.ga.entity.User;
import com.ga.entity.UserProfile;
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
import static org.mockito.Mockito.when;

public class UserProfileDaoTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    private MockMvc mockMvc;

    @InjectMocks
    private UserProfileDaoImpl userProfileDao;

    @Mock
    private UserDao userDao;

    @Mock
    private SessionFactory sessionFactory;

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    Session session;

    @Mock
    private Transaction transaction;

    @Mock
    private Query<UserProfile> query;

    @InjectMocks
    private UserProfile userProfile2;

    @Mock
    private UserProfile userProfile;

    @InjectMocks
    private User user2;

    @Mock
    private User user;

    @Before
    public void initDummyUser() {
        user2.setUserId(1L);
        user2.setUsername("batman");
        user2.setPassword("robin");

        userProfile2.setProfileId(1L);
        userProfile2.setAddress("123 Fake Street USA");
        userProfile2.setEmail("myfake@email.com");
        userProfile2.setMobile("123-456-7890");

        user2.setProfile(userProfile2);
//        mockMvc = MockMvcBuilders.standaloneSetup(userDao).build();
//
//        sampleUserList = Arrays.asList(
//                new User(
//                        "batman",
//                        "robin"
//                )
//        );
//
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.getTransaction()).thenReturn(transaction);
        when(session.createQuery(anyString())).thenReturn(query);
    }

    @Test
    public void getUserProfile() {
        getUserProfile_UserProfile_Success();
    }

    @Test
    public void createUserProfile() {
        createUserProfile_UserProfile_Success();
    }

    @Test
    public void updateProfile() {
        updateUserProfile_UserProfile_Success();
    }

    private void getUserProfile_UserProfile_Success(){
        when(userDao.getUserByUsername(anyString())).thenReturn(user2);
//        User savedUser = userDao.getUserByUsername(user2.getUsername());
        UserProfile savedProfile = userProfileDao.getUserProfile("test");
        assertNotNull("Test returned null object, expected non-null", savedProfile);
        assertEquals(savedProfile, userProfile2);
    }

    private void createUserProfile_UserProfile_Success(){
        when(userDao.getUserByUsername(anyString())).thenReturn(user2);
//        User savedUser = userDao.getUserByUsername(user2.getUsername());
        UserProfile savedProfile = userProfileDao.createUserProfile("test", userProfile2);
        assertNotNull("Test returned null object, expected non-null", savedProfile);
        assertEquals(savedProfile, userProfile2);
    }


    private void updateUserProfile_UserProfile_Success(){
        when(userDao.getUserByUsername(anyString())).thenReturn(user2);
//        User savedUser = userDao.getUserByUsername(user2.getUsername());
        UserProfile savedProfile = userProfileDao.updateProfile("test", userProfile2);
        assertNotNull("Test returned null object, expected non-null", savedProfile);
        assertEquals(savedProfile, userProfile2);
    }


}