package com.project.backend.dto;

import com.project.backend.entity.Account;
import com.project.backend.entity.RankAccount;
import com.project.backend.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private Long id;
    private String username;
    private Integer level;
    private String password;
    private RankAccount rankTypeId;
    private Double accountBalance;
    private byte[] avatar;
    private String email;
    private User user;
}
