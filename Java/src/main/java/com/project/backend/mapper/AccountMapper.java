package com.project.backend.mapper;

import com.project.backend.dto.AccountDto;
import com.project.backend.entity.Account;
import com.project.backend.entity.RankAccount;

public class AccountMapper {
    public static AccountDto MapToAccountDto(Account account){
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setUsername(account.getUsername());
        accountDto.setLevel(account.getLevel());
        accountDto.setRankTypeId(account.getRankAccount());
        accountDto.setPassword(account.getPassword());
        accountDto.setAccountBalance(account.getAccountBalance());
        accountDto.setEmail(account.getEmail());
        accountDto.setUser(account.getUser());
        return accountDto;
    }
    public static Account MapToAccount(AccountDto accountDto){
        Account account = new Account();
        account.setId(accountDto.getId());
        account.setUsername(accountDto.getUsername());
        account.setLevel(accountDto.getLevel());
        account.setPassword(accountDto.getPassword());
        account.setRankAccount(accountDto.getRankTypeId());
        account.setAccountBalance(accountDto.getAccountBalance());
        account.setEmail(accountDto.getEmail());
        account.setUser(accountDto.getUser());
        return account;
    }
}
