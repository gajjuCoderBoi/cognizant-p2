package com.ga.service;

import com.ga.entity.UserProfile;

public interface UserProfileService {
    public UserProfile createUserProfile(UserProfile newProfile, String username);

    public UserProfile updateProfile(UserProfile newProfile, String username);

    public UserProfile getUserProfile(String username);

}
