package com.ga.entity;

import javafx.util.Pair;

public class JwtResponse {

    private String jwt;

    private String username;

    public JwtResponse(String jwt) {
        this.jwt = jwt;
    }

    public JwtResponse(Pair<String, String> signup) {
        username = signup.getKey();
        jwt = signup.getValue();
    }

    public String getToken() {
        return this.jwt;
    }

    public JwtResponse(String jwt, String username) {
        this.jwt = jwt;
        this.username = username;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
