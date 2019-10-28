package com.ga.service;

import com.ga.dao.UserRoleDao;
import com.ga.dao.UserRoleDaoImpl;
import com.ga.entity.UserRole;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserRoleServiceTest {


    @Mock
    private UserRoleService userRoleService;


    @InjectMocks
    private UserRole userRole;

    @Mock
    UserRoleDaoImpl userRoleDao;



    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Before
    public void initializeDummies() {
        userRole.setName("ROLE_ADMIN");
    }

    private void createRole_UserRole_Success() {
         when(userRoleDao.createRole(any())).thenReturn(userRole);

        assertNotNull(userRoleDao.createRole(userRole));

    }

    private void getRole_UserRole_Success() {
        when(userRoleDao.getRoleByName(any())).thenReturn(userRole);

        assertNotNull(userRoleDao.getRoleByName("ADMIN"));

    }

    @Test
    public void createRole() {
        createRole_UserRole_Success();
    }

    @Test
    public void getRole() {
        getRole_UserRole_Success();
    }
}