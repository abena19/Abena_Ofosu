package com.company.chatterbook.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ChatterbookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        // Standard set up method, for instantiating test objects
        // Don't have to do anything special for mockMvc since it's Autowired
    }
    private String testUserName = "Luis"; //test username

    @Test
    void contextLoads() {
    }


    // Testing GET methods for returning users

    @Test
    void shouldReturnUserList() throws Exception {
        mockMvc.perform(get("/users"))                // Perform the GET request
                .andDo(print())                          // Print results to console
                .andExpect(status().isOk());              // ASSERT (status code is 200)
    }

    @Test
    void shouldReturnUserWithUsername() throws Exception {
        mockMvc.perform(get("/user/" + testUserName))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnChatterPostsForUsername() throws Exception {
        mockMvc.perform(get("/chatterposts/" + testUserName))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnNotFoundForNonExistingUser() throws Exception {
        mockMvc.perform(get("/user/" + testUserName))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

}
