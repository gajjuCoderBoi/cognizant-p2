package com.ga.dao;

import com.ga.entity.User;
import com.ga.entity.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    UserRoleDao userRoleDao;


    @PreAuthorize("ADMIN")
    @Override
    public List<User> listUsers() {
        List<User> users = null;
        Session session = sessionFactory.getCurrentSession();
        users = session.createQuery("FROM User").getResultList();
        try {
            session.beginTransaction();

        } finally {
            session.close();
        }
        return users;
    }

    @Override
    public User signup(User user) {
        List<UserRole> roles = new ArrayList<>();
        for (UserRole userRole:user.getRoles()){
            roles.add(userRoleDao.getRoleByName(userRole.getName()));
        }

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            user.setRoles(roles);
            session.save(user);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
        return user;
    }

    @Override
    public User login(User user) {
        Session session = sessionFactory.getCurrentSession();
        User savedUser;
        try {
            session.beginTransaction();
            savedUser = (User) session.createQuery("FROM User u WHERE u.username = '" +
                    user.getUsername() + "'").getSingleResult();
        } finally {
            session.close();
        }
        return savedUser;
    }

    @Override
    public User update(User user, String username) {
        User saveduser = getUserByUsername(username);

        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            saveduser.setPassword(user.getPassword());
            session.update(saveduser);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
        return saveduser;
    }

    @Override
    public User delete(Long userId) {
        Session session = sessionFactory.getCurrentSession();
        User deletedUser;
        try {
            deletedUser = session.get(User.class, userId);
            session.delete(deletedUser);
            session.getTransaction().commit();

        } finally {
            session.close();
        }
        System.out.println(deletedUser);
        return deletedUser;
    }

    @Override
    public User getUserByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        User user;
        try {
            session.beginTransaction();
            user = (User)session.createQuery("FROM User u WHERE u.username = '" +
                    username + "'").uniqueResult();
        } finally {
            session.close();
        }
        return user;
    }
}
