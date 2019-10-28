package com.ga.controller;

import com.ga.entity.UserProfile;
import com.ga.service.UserProfileService;
import com.ga.service.UserService;
import javafx.util.Pair;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class ProfileControllerTest {

    private MockMvc mockMvc;

    private UserProfile sampleProfile;


    @InjectMocks
    private ProfileController profileController;

    @Mock
    private UserProfileService userProfileService;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(profileController).build();
        sampleProfile = new UserProfile(
                "myfake@email.com",
                "123-123-1234",
                "123 Fake Street"
        );

    }


    @Test
    public void getProfile_Profile_Success() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/profile")
                .contentType(MediaType.APPLICATION_JSON)
                .header("authorization", "Bearer 1234");

        when(userProfileService.getUserProfile(anyString())).thenReturn(sampleProfile);


        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "    \"email\": \"myfake@email.com\",\n" +
                        "    \"mobile\": \"123-123-1234\",\n" +
                        "    \"address\": \"123 Fake Street\"\n" +
                        "}"))
                .andReturn();
    }

    @Test
    public void createProfile_Profile_Success() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/profile")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \t\"address\": \"123 Fake Street\",\n" +
                        "    \t\"email\": \"myfake@email.com\",\n" +
                        "    \t\"mobile\": \"123-123-1234\"\n" +
                        "}")
                .header("authorization", "Bearer 1234");

        when(userProfileService.createUserProfile(any(), anyString())).thenReturn(sampleProfile);


        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "    \"email\": \"myfake@email.com\",\n" +
                        "    \"mobile\": \"123-123-1234\",\n" +
                        "    \"address\": \"123 Fake Street\"\n" +
                        "}"))
                .andReturn();
    }

    private void updateProfile_Profile_Success() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/profile")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \t\"address\": \"Lorem Ipsum\",\n" +
                        "    \t\"email\": \"myfake@email.com\",\n" +
                        "    \t\"mobile\": \"123-123-1234\"\n" +
                        "}")
                .header("authorization", "Bearer 1234");

        sampleProfile.setEmail("Lorem Ipsum");
        when(userProfileService.updateProfile(any(), anyString())).thenReturn(sampleProfile);


        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "    \"email\": \"Lorem Ipsum\",\n" +
                        "    \"mobile\": \"123-123-1234\",\n" +
                        "    \"address\": \"123 Fake Street\"\n" +
                        "}"))
                .andReturn();

    }

    @Test
    public void getProfile() throws Exception {
        getProfile_Profile_Success();
    }

    @Test
    public void createProfile() throws Exception {
        createProfile_Profile_Success();
    }

    @Test
    public void updateProfile() throws Exception {
        updateProfile_Profile_Success();
    }
}