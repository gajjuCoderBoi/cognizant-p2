package com.ga.service;

import com.ga.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<User> listUsers() {
        // TODO
        return null;
    }

    @Override
    public String signup(User user) {
        // TODO
        return null;
    }

    @Override
    public String login(User user) {
        // TODO
        return null;
    }

    @Override
    public User update(User user, Long userId) {
        // TODO
        return null;
    }

    @Override
    public User delete(Long userId) {
        // TODO
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // TODO
        return null;
    }
}
