package com.project.backend.dto;

import com.project.backend.entity.Account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepositDto {
    private Long id;
    private String txnRef;
    private Account account;
    private Double money;
}
