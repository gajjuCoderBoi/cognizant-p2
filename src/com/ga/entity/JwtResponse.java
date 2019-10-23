package com.ga.entity;

import com.ga.config.JwtUtil;
import javafx.util.Pair;

public class JwtResponse {

    private String jwt;

    private String username;

    public JwtResponse(String jwt) {
        this.jwt = JwtUtil.extractToken(jwt);
    }

    public JwtResponse(Pair<String, String> signup) {
        username = signup.getKey();
        jwt = JwtUtil.extractToken(signup.getValue());
    }

    public String getToken() {
        return this.jwt;
    }

    public String getUsername() {
        return username;
    }

}
