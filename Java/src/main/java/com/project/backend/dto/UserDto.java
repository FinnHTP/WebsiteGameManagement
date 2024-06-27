package com.project.backend.dto;

import com.project.backend.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String sdt;
    private byte[] avatar;
    private Account account;
}
