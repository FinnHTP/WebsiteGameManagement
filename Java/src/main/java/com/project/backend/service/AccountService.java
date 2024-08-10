package com.project.backend.service;

import com.project.backend.dto.AccountDto;
import com.project.backend.entity.Account;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AccountService {
    Account createAccountEmail(Account account);
    AccountDto createAccount(AccountDto accountDto);
    List<AccountDto> getAllAccount();
    AccountDto getAccountById(Long id);
    AccountDto updateAccount(Long id, AccountDto accountDto);
    AccountDto updateAccountBalance(Long id, AccountDto accountDto);
    void deleteAccount(Long id);
    AccountDto getAccountByUsername(String username);
}
