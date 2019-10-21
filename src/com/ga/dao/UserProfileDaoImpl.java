package com.ga.dao;

import com.ga.entity.UserRole;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserProfileDaoImpl implements UserProfileDao {

    @Autowired
    SessionFactory sessionFactory;
}
