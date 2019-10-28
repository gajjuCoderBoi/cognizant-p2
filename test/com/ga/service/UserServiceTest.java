package com.ga.service;

import com.ga.config.JwtUtil;
import com.ga.dao.UserDao;
import com.ga.entity.User;
import com.ga.entity.UserRole;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    private List<User> userList;

    @InjectMocks
    private UserServiceImpl userService;

    @InjectMocks
    private User user;

    @InjectMocks
    private UserRole userRole;

    @Mock
    UserDao userDao;

    @Mock
    private JwtUtil jwtUtil;

    @Mock
    private PasswordEncoder bCryptPasswordEncoder;


    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
        userList = Arrays.asList(
                new User("xyz","xyz"),
                new User("abc","abc")
        );
    }

    @Before
    public void initializeDummies() {
        userRole.setName("ROLE_ADMIN");

        user.setUserId(1L);
        user.setUsername("batman");
        user.setPassword("robin");
        user.getRoles().add(userRole);
    }

    private void listUsers_List_Success() {
      /*  List<User> expected = Arrays.asList(
                new User("xyz","xyz"),
                new User("abc","abc")
        );
*/
        when(userDao.listUsers()).thenReturn(userList);
        List<User> actual = userService.listUsers();
        assertNotNull(actual);

    }

    private void signup_ReturnsJwt_Success() {
        String expectedToken = "12345";

        when(userDao.signup(any())).thenReturn(user);
        when(userDao.getUserByUsername(anyString())).thenReturn(user);
        when(jwtUtil.generateToken(any())).thenReturn(expectedToken);
        when(bCryptPasswordEncoder.encode(user.getPassword())).thenReturn("robin");

        String actualToken = userService.signup(user).getValue();

        assertEquals(actualToken, expectedToken);
    }


    private void login_JWTResponse_Success() {
        String expectedToken = "12345";

        when(userDao.login(any())).thenReturn(user);
        when(bCryptPasswordEncoder.matches(any(),any())).thenReturn(true);
        when(userDao.getUserByUsername(anyString())).thenReturn(user);
        when(jwtUtil.generateToken(any())).thenReturn(expectedToken);
        when(bCryptPasswordEncoder.encode(user.getPassword())).thenReturn("robin");

        String actualToken = userService.login(user).getValue();

        assertEquals(actualToken, expectedToken);

    }

    private void update_JWTResponse_Success() {
        String expectedToken = "12345";
        when(bCryptPasswordEncoder.encode(user.getPassword())).thenReturn("robin");
        when(jwtUtil.getUsernameFromToken(anyString())).thenReturn(user.getUsername());
        when(userDao.update(any(), anyString())).thenReturn(user);
        String actualToken = userService.update(user, "12345").getValue();

        assertEquals(actualToken, expectedToken);
    }

    private void delete_Long_Success() {
        Long expected = 1l;

        when(userDao.delete(anyLong())).thenReturn(user);

        User user = userDao.delete(1l);

        assertEquals(expected, user.getUserId());

    }


    @Test
    public void listUsers() {
        listUsers_List_Success();
    }

    @Test
    public void signup() {
        signup_ReturnsJwt_Success();
    }

    @Test
    public void login() {
        login_JWTResponse_Success();
    }

    @Test
    public void update() {
        update_JWTResponse_Success();
    }

    @Test
    public void delete() {
        delete_Long_Success();
    }

}