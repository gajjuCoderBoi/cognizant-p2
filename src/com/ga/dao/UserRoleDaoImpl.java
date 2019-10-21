package com.ga.dao;

import com.fasterxml.jackson.core.PrettyPrinter;
import com.ga.entity.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRoleDaoImpl implements UserRoleDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public UserRole createRole(UserRole userRole) {
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            session.save(userRole);
            session.getTransaction().commit();
        }finally {
            session.close();
        }
        return userRole;
    }

    @Override
    public UserRole getRoleByName(String name) {
        UserRole userRole=null;
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            userRole = (UserRole) session.createQuery("FROM UserRole ur where u.name='"+name+"'").uniqueResult();
        }finally {
            session.close();
        }
        return userRole;
    }

    @Override
    public UserRole getRoleById(Long id) {
        UserRole userRole=null;
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            userRole = session.get(UserRole.class, id);
        }finally {
            session.close();
        }
        return userRole;
    }
}
