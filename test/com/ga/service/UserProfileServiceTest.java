package com.ga.service;

import com.ga.config.JwtUtil;
import com.ga.dao.UserProfileDaoImpl;
import com.ga.entity.UserProfile;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserProfileServiceTest {

    @InjectMocks
    private UserProfile userProfile;

    @Mock
    private UserProfileDaoImpl userProfileDao;

    @InjectMocks
    private UserProfileServiceImpl userProfileService;

    @Mock
    JwtUtil jwtUtil;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Before
    public void initializeDummies() {
        userProfile.setEmail("fake@fake.com");
        userProfile.setAddress("123 some address");
        userProfile.setMobile("111-111-1111");
    }

    @Test
    public void createUserProfile_UserProfile_Success() {
        /*UserProfile expected = new UserProfile(
                "fake@fake.com",
                "111-111-1111",
                "123 some address");
*/
//        when(jwtUtil.getUsernameFromToken(anyString())).thenReturn("123");
        when(userProfileDao.createUserProfile(anyString(), any())).thenReturn(userProfile);

        UserProfile userProfile1 = userProfileDao.createUserProfile("someusername",userProfile);

        assertNotNull(userProfile1);
    }

    @Test
    public void updateProfile_UserProfile_Success() {
        when(userProfileDao.updateProfile(anyString(), any())).thenReturn(userProfile);

        UserProfile userProfile1 = userProfileDao.updateProfile("someusername",userProfile);

        assertNotNull(userProfile1);

    }

    @Test
    public void getUserProfile_UserProfile_Success() {
//        when(jwtUtil.getUsernameFromToken(anyString())).thenReturn("123");
        when(userProfileDao.getUserProfile(anyString())).thenReturn(userProfile);

        UserProfile userProfile1 = userProfileDao.getUserProfile("someusername");

        assertNotNull(userProfile1);
    }
}