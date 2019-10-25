package com.ga.entity;

import javax.persistence.*;


@Entity
@Table(name = "profiles")
public class UserProfile {
    @Id
    @Column(name = "profile_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "address")
    private String address;

    public void setUser(User user) {
        this.user = user;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;

    public UserProfile(String email, String mobile, String address) {
        this.email = email;
        this.mobile = mobile;
        this.address = address;
    }

    public void updateProfile(UserProfile profile) {
        this.email = profile.email;
        this.mobile = profile.mobile;
        this.address = profile.address;
    }

    public UserProfile(String email, String mobile, String address, User user) {
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.user = user;
    }

    public UserProfile() {}

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
