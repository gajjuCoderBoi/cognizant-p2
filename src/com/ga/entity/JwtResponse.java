package com.ga.entity;

import javafx.util.Pair;

public class JwtResponse {

    private String jwt;

    private String username;

    public JwtResponse(String jwt) {
        if(jwt.startsWith("Bearer "))
            jwt = jwt.substring(7);
        this.jwt = jwt;
    }

    public JwtResponse(Pair<String, String> signup) {
        username = signup.getKey();
        if(signup.getValue().startsWith("Bearer "))
            jwt = signup.getValue().substring(7);
    }

    public String getToken() {
        return this.jwt;
    }

    public String getUsername() {
        return username;
    }

}
