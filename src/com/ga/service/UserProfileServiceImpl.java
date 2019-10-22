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
    public UserProfile createUserProfile(UserProfile newProfile, String username) {
        return userProfileDao.createUserProfile(username, newProfile);
    }

    @Override
    public UserProfile updateProfile(UserProfile newProfile, String username) {
        return userProfileDao.updateProfile(username, newProfile);
    }

    @Override
    public UserProfile getUserProfile(String username) {
        return userProfileDao.getUserProfile(username);
    }
}
