package com.project.backend.service;

import com.project.backend.dto.AccountDto;
import com.project.backend.entity.Account;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    List<AccountDto> getAllAccount();
    AccountDto getAccountById(Long id);
    AccountDto updateAccount(Long id, AccountDto accountDto);
    void deleteAccount(Long id);
}
