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
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            user.setProfile(newProfile);
            session.save(user);
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
