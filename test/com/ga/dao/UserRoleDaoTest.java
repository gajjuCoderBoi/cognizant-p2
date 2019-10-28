package com.ga.dao;

import com.ga.entity.UserRole;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.util.AssertionErrors.*;

public class UserRoleDaoTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Spy
    @InjectMocks
    private UserRoleDaoImpl userRoleDao;

    @InjectMocks
    private UserRole dummyuserRole;

    @Before
    public void initDummy(){
        dummyuserRole.setName("ADMIN");
        dummyuserRole.setRoleId(1l);
    }

    @Test
    public void createRole() {
        createRole_UserRole_Success();
        // TODO
    }



    @Test
    public void getRoleByName() {
        getRoleByName_UserRole_Success();
        // TODO
    }

    @Test
    public void getRoleById() {
        getRoleById_UserRole_Success();
        // TODO
    }

    public void createRole_UserRole_Success(){
        doReturn(dummyuserRole).when(userRoleDao).createRole(any());

        UserRole userRole = userRoleDao.createRole(dummyuserRole);

        assertNotNull("Test returned null object, expected non-null", userRole);

    }

    public void getRoleByName_UserRole_Success(){
        doReturn(dummyuserRole).when(userRoleDao).getRoleByName(any());

        UserRole userRole = userRoleDao.getRoleByName(dummyuserRole.getName());

        assertNotNull("Test returned null object, expected non-null", userRole);

    }

    public void getRoleById_UserRole_Success(){
        doReturn(dummyuserRole).when(userRoleDao).getRoleById(any());

        UserRole userRole = userRoleDao.getRoleById(dummyuserRole.getRoleId());

        assertNotNull("Test returned null object, expected non-null", userRole);
    }
}