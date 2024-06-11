package com.project.backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.backend.controller.UserController;
import com.project.backend.dto.AccountDto;
import com.project.backend.dto.UserDto;
import com.project.backend.entity.User;
import com.project.backend.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class UserControllerTest {
    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testGetAllUsers() throws Exception {
        // List of example users
        UserDto user1 = new UserDto(1L,"user1", "demo", "0000000001", 1L);
        UserDto user2 = new UserDto(2L,"user2", "demo", "0000000002", 2L);

        // Mock service return list of users when called
        when(userService.getAllUser()).thenReturn(Arrays.asList(user1, user2));

        // Initiate mockMvc with controller need to be tested
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

        // Send request GET to endpoint "api/users" and check the result
        mockMvc.perform(MockMvcRequestBuilders.get("/api/user")
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].firstname").value("user1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].lastname").value("demo"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].sdt").value("0000000001"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].accountId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].firstname").value("user2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].lastname").value("demo"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].sdt").value("0000000002"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].accountId").value(2));
    }

    @Test
    public void createUser() throws Exception {
        // Create a new user
        UserDto user1 = new UserDto(null,"user1", "demo", "0000000001", 1L);

        // ID sent back from service
        Long id = 1L;
        user1.setId(id);

        // Mock service return saved user when called
        when(userService.createUser(any(UserDto.class))).thenReturn(user1);

        //Initiate mockMvc with controller needed testing
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

        // Send request POST to endpoint "api/user" with JSON data of new user and check the result
        mockMvc.perform(MockMvcRequestBuilders.post("/api/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(user1)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstname").value("user1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastname").value("demo"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.sdt").value("0000000001"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.accountId").value(1));
    }

    @Test
    public void testUpdateUser() throws Exception {
        // Create a test account with ID is null
        Long userId = 1l;
        UserDto userDto = new UserDto(userId, "user1", "demo", "0000000002", 1L);

        // Mock service return updated user when call
        when(userService.updateUser(eq(userId), any(UserDto.class))).thenReturn(userDto);

        // Initiate Mock Mvc with the controller to be tested
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

        // Send request PUT to endpoint "/api/user/{id}" with JSON data of updated user and check the result
        mockMvc.perform(MockMvcRequestBuilders.put("/api/user/{id}", userId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(userDto)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists()) // Check if id is created automatically and existing
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstname").value("user1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastname").value("demo"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.sdt").value("0000000002"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.accountId").value(1));
    }

    @Test
    public void testGetUserById() throws Exception {
        // Create a demo user to return
        Long userId = 1L;
        UserDto userDto = new UserDto(userId, "user1", "demo", "0000000002", 1L);

        // Mock service return the demo user with ID provided
        when(userService.getUserById(anyLong())).thenReturn(userDto);

        // Send request GET to endpoint "/api/user/{id}" and check the result
        mockMvc.perform(MockMvcRequestBuilders.get("/api/user/{id}", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(userId))
                .andExpect(jsonPath("$.firstname").value("user1"))
                .andExpect(jsonPath("$.lastname").value("demo"))
                .andExpect(jsonPath("$.sdt").value("0000000002"))
                .andExpect(jsonPath("$.accountId").value(1));
    }

    @Test
    public void testDeleteUserById() throws Exception {
        Long userId = 1L;

        // Send request DELETE to endpoint "/api/user/{id}" and check the result
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/user/{id}", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("User deleted successfully"));
    }
}
