package com.project.backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.backend.controller.AccountController;
import com.project.backend.dto.AccountDto;
import com.project.backend.service.AccountService;
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

public class AccountControllerTest {
    private MockMvc mockMvc;

    @Mock
    private AccountService accountService;

    @InjectMocks
    private AccountController accountController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();
    }

    @Test
    public void testGetAllAccount() throws Exception {
        // Danh sách mẫu các tài khoản
        AccountDto account1 = new AccountDto(1L, "dung", 1, "123", 1L, 100.0, "dung1@gmail.com");
        AccountDto account2 = new AccountDto(2L, "phat", 2, "123", 2L, 200.0, "phat2@gmail.com");

        // Mock service trả về danh sách các tài khoản mẫu khi được gọi
        when(accountService.getAllAccount()).thenReturn(Arrays.asList(account1, account2));

        // Khởi tạo mockMvc với controller cần test
        mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();

        // Gửi yêu cầu GET tới endpoint "/api/accounts" và kiểm tra kết quả
        mockMvc.perform(MockMvcRequestBuilders.get("/api/account")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].username").value("dung"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].level").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].password").value("123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].rankTypeId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].accountBalance").value(100.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].email").value("dung1@gmail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].username").value("phat"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].level").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].password").value("123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].rankTypeId").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].accountBalance").value(200.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].email").value("phat2@gmail.com"));
    }


    @Test
    public void testCreateAccount() throws Exception {
        // Tạo một tài khoản mới
        AccountDto newAccount = new AccountDto(null, "dung", 1, "dung2310", 1L, 100.0, "dung@gmail.com");

        // ID được trả về từ service
        Long id = 1L;
        newAccount.setId(id);
        // Mock service trả về tài khoản đã lưu khi được gọi
        when(accountService.createAccount(any(AccountDto.class))).thenReturn(newAccount);

        // Khởi tạo mockMvc với controller cần test
        mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();

        // Gửi yêu cầu POST tới endpoint "/api/accounts" với dữ liệu JSON của tài khoản mới và kiểm tra kết quả
        mockMvc.perform(MockMvcRequestBuilders.post("/api/account")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(newAccount)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("dung"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.level").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("dung2310"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rankTypeId").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.accountBalance").value(100.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("dung@gmail.com"));
    }

    @Test
    public void testUpdateAccount() throws Exception {
        // Tạo một tài khoản cần cập nhật với id là null
        Long accountId = 1l;
        AccountDto updatedAccount = new AccountDto(accountId, "updated", 2, "password", 2L, 200.0, "updated@gmail.com");

        // Mock service trả về tài khoản đã cập nhật khi được gọi
        when(accountService.updateAccount(eq(accountId), any(AccountDto.class))).thenReturn(updatedAccount);

        // Khởi tạo mockMvc với controller cần test
        mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();

        // Gửi yêu cầu PUT tới endpoint "/api/accounts/{id}" với dữ liệu JSON của tài khoản cập nhật và kiểm tra kết quả
        mockMvc.perform(MockMvcRequestBuilders.put("/api/account/{id}", accountId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(updatedAccount)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists()) // Kiểm tra rằng id được tạo tự động và tồn tại
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("updated"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.level").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("password"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rankTypeId").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.accountBalance").value(200.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("updated@gmail.com"));
    }

    @Test
    public void testGetAccountById() throws Exception {
        // Tạo một tài khoản mẫu để trả về
        Long accountId = 1L;
        AccountDto accountDto = new AccountDto(accountId, "username", 1, "password", 1L, 100.0, "email@example.com");

        // Mock service trả về tài khoản mẫu khi được gọi với id tương ứng
        when(accountService.getAccountById(anyLong())).thenReturn(accountDto);

        // Gửi yêu cầu GET tới endpoint "/api/accounts/{id}" và kiểm tra kết quả
        mockMvc.perform(MockMvcRequestBuilders.get("/api/account/{id}", accountId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(accountId))
                .andExpect(jsonPath("$.username").value("username"))
                .andExpect(jsonPath("$.level").value(1))
                .andExpect(jsonPath("$.password").value("password"))
                .andExpect(jsonPath("$.rankTypeId").value(1))
                .andExpect(jsonPath("$.accountBalance").value(100.0))
                .andExpect(jsonPath("$.email").value("email@example.com"));
    }

    @Test
    public void testDeleteAccountById() throws Exception {
        Long accountId = 1L;

        // Gửi yêu cầu DELETE tới endpoint "/api/accounts/{id}" và kiểm tra kết quả
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/account/{id}", accountId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Account deleted successfully"));
    }
}
