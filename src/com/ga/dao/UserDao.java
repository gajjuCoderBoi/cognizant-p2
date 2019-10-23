package com.ga.dao;

import com.ga.entity.User;

import java.util.List;

public interface UserDao {
    public List<User> listUsers();
    public User signup(User user);
    public User login(User user);
    public User update(User user, String username);
    public User delete(Long userId);
    public User getUserByUsername(String username);
}
