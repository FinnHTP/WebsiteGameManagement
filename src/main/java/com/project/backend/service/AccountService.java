package com.project.backend.service;

import com.project.backend.dto.AccountDto;
import com.project.backend.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    List<AccountDto> getAllAccount();
    AccountDto getAccountById(Long id);
    AccountDto updateAccount(Long id, AccountDto accountDto);
    void deleteAccount(Long id);
    Account findByUsername(String username);
}
