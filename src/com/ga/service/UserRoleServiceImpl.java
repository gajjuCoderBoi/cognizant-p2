package com.ga.service;

import com.ga.dao.UserRoleDao;
import com.ga.entity.UserRole;
import com.sun.org.apache.bcel.internal.generic.ARETURN;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleDao userRoleDao;

    @Override
    public UserRole createRole(UserRole newRole) {
        return userRoleDao.createRole(newRole);
    }

    @Override
    public UserRole getRole(String roleName) {

        return userRoleDao.getRoleByName(roleName);
    }
}
