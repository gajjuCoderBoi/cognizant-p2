package com.ga.service;

import com.ga.config.JwtUtil;
import com.ga.dao.UserProfileDao;
import com.ga.entity.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    UserProfileDao userProfileDao;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public UserProfile createUserProfile(UserProfile newProfile, String token) {
        String username = jwtUtil.getUsernameFromToken(token);
        return userProfileDao.createUserProfile(username, newProfile);
    }

    @Override
    public UserProfile updateProfile(UserProfile newProfile, String token) {
        String username = jwtUtil.getUsernameFromToken(token);
        return userProfileDao.updateProfile(username, newProfile);
    }

    @Override
    public UserProfile getUserProfile(String token) {
        String username = jwtUtil.getUsernameFromToken(token);
        return userProfileDao.getUserProfile(username);
    }
}
