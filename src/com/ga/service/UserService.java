package com.ga.service;

import com.ga.entity.User;
import javafx.util.Pair;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    public List<User> listUsers();

    public Pair<String, String> signup(User user);

    public Pair<String, String> login(User user);

    public User update(User user, Long userId);

    public User delete(Long userId);
}
