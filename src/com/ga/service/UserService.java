package com.ga.service;

import com.ga.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    public List<User> listUsers();

    public String signup(User user);

    public String login(User user);

    public User update(User user, Long userId);

    public User delete(Long userId);
}
