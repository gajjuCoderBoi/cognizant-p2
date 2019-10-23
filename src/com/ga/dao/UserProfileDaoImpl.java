package com.ga.dao;

import com.ga.entity.User;
import com.ga.entity.UserProfile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserProfileDaoImpl implements UserProfileDao {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    UserDao userDao;


    @Override
    public UserProfile createUserProfile(String username, UserProfile newProfile) {
        User user = userDao.getUserByUsername(username);
        newProfile.setUser(user);
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            session.save(newProfile);
            session.getTransaction().commit();
        }finally {
            session.close();
        }
        return newProfile;
    }

    @Override
    public UserProfile updateProfile(String username, UserProfile newProfile) {
        User user = userDao.getUserByUsername(username);
        UserProfile userProfile = user.getProfile();
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            userProfile.updateProfile(newProfile);
            session.update(userProfile);
            session.getTransaction().commit();
        }finally {
            session.close();
        }
        return newProfile;
    }

    @Override
    public UserProfile getUserProfile(String username) {
        return userDao.getUserByUsername(username).getProfile();
    }
}
