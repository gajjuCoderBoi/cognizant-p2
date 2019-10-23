package com.ga.controller;

import com.ga.entity.UserProfile;
import com.ga.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping
    public ResponseEntity<?> getProfile(@RequestHeader("Authorization") String token){
        if(token== null) return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        return ResponseEntity.ok(userProfileService.getUserProfile(token));
    }

    @PostMapping
    public ResponseEntity<?> createProfile(@RequestBody UserProfile userProfile, @RequestHeader("Authorization") String token){
        if(token== null) return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        return ResponseEntity.ok(userProfileService.createUserProfile(userProfile, token));
    }

    @PutMapping
    public ResponseEntity<?> updateProfile(@RequestBody UserProfile userProfile, @RequestHeader("Authorization") String token){
        if(token== null) return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        return ResponseEntity.ok(userProfileService.updateProfile(userProfile, token));
    }

}
