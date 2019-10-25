package com.ga.controller;

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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    private MockMvc mockMvc;


    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }


    @Test
    public void signup_User_Success() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/user/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(createUserInJson("joe","abc"));

        Pair<String, String> tempPair = new Pair<>("joe", "12345");

        when(userService.signup(any())).thenReturn(tempPair);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "\t\"username\" : \"joe\",\n" +
                        "\t\"token\" : \"12345\"\n" +
                        "}"))
                .andReturn();


    }

    @Test
    public void login_User_Success() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/user/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(createUserInJson("joe","abc"));

        Pair<String, String> tempPair = new Pair<>("joe", "12345");

        when(userService.login(any())).thenReturn(tempPair);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "\t\"username\" : \"joe\",\n" +
                        "\t\"token\" : \"12345\"\n" +
                        "}"))
                .andReturn();

    }

    @Test
    public void resetPassword_User_Password() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/user/reset")
                .contentType(MediaType.APPLICATION_JSON)
                .header("authorization", "Bearer 1234")
                .content("{\n" +
                        "\t\"password\" : \"123\"\n" +
                        "}");

        Pair<String, String> tempPair = new Pair<>("joe", "12345");

        when(userService.update(any(), any())).thenReturn(tempPair);


        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "\t\"username\" : \"joe\",\n" +
                        "\t\"token\" : \"12345\"\n" +
                        "}"))
                .andReturn();
    }

    private static String createUserInJson(String username, String password) {
        return "{ \"username\": \"" + username + "\", " +
                "\"password\":\"" + password + "\"}";
    }

}