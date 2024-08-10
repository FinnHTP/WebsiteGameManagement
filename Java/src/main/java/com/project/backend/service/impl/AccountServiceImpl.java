package com.project.backend.service.impl;

import com.project.backend.dto.AccountDto;
import com.project.backend.entity.Account;
import com.project.backend.entity.RankAccount;
import com.project.backend.entity.User;
import com.project.backend.exception.ResourceNotFoundException;
import com.project.backend.mapper.AccountMapper;
import com.project.backend.repository.AccountRepository;
import com.project.backend.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    @Override
    public Account createAccountEmail(Account account) {
        RankAccount rankAccount = new RankAccount();
        // Set default account balance is 0, rank type is 1 equal to Bronze and account level is 1 when user fresh create an account
        account.setAccountBalance(0.0);
        account.setLevel(1);
        rankAccount.setId(1L);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setRankAccount(rankAccount);
        account.setUser(new User());
        Account newAccount = accountRepository.save(account);
        return newAccount;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.MapToAccount(accountDto);
        RankAccount rankAccount = new RankAccount();
        // Set default account balance is 0, rank type is 1 equal to Bronze and account level is 1 when user fresh create an account
        account.setAccountBalance(0.0);
        account.setLevel(1);
        rankAccount.setId(1L);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        account.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        account.setRankAccount(rankAccount);
        Account newAccount = accountRepository.save(account);
        return AccountMapper.MapToAccountDto(newAccount);
    }

    @Override
    public List<AccountDto> getAllAccount() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account) -> AccountMapper.MapToAccountDto(account)).collect(Collectors.toList());
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account can't be found with given id " + id));
        return AccountMapper.MapToAccountDto(account);
    }

    @Override
    public AccountDto updateAccount(Long id, AccountDto accountDto) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account can't be found with given id " + id));
        // Update account info (ID, username, password, email) do not update (level, rank type id, balance)
        account.setId(accountDto.getId());
        account.setUsername(accountDto.getUsername());
        account.setPassword(accountDto.getPassword());
        account.setEmail(accountDto.getEmail());
        Account updatedAccount = accountRepository.save(account);
        return AccountMapper.MapToAccountDto(updatedAccount);
    }

    @Override
    public AccountDto updateAccountBalance(Long id, AccountDto accountDto) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account can't be found with given id " + id));
        // Update account info (ID, username, password, email) do not update (level, rank type id, balance)
        account.setAccountBalance(accountDto.getAccountBalance());
        Account updatedAccount = accountRepository.save(account);
        return AccountMapper.MapToAccountDto(updatedAccount);
    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account can't be found with given id " + id));
        accountRepository.deleteById(id);
    }

	@Override
	public AccountDto getAccountByUsername(String username) {
		Account account = accountRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("Account can't be found with username " + username));
        return AccountMapper.MapToAccountDto(account);
	}

}
