package com.project.backend.controller;

import com.project.backend.dto.AccountDto;
import com.project.backend.entity.Account;
import com.project.backend.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/account")
public class AccountController {
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto){
        AccountDto savedAccount = accountService.createAccount(accountDto);
        return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccount(){
        List<AccountDto> accounts = accountService.getAllAccount();
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable("id") Long id){
        AccountDto account = accountService.getAccountById(id);
        return ResponseEntity.ok(account);
    }

    @PutMapping("{id}")
    public ResponseEntity<AccountDto> updateAccount(@PathVariable("id") Long id, @RequestBody AccountDto accountDto){
        AccountDto newAccountDto = accountService.updateAccount(id, accountDto);
        return new ResponseEntity<>(newAccountDto, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAccountById(@PathVariable("id") Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account deleted successfully");
    }
}   
