package com.project.backend.controller;

import com.project.backend.dto.RankAccountDto;
import com.project.backend.entity.RankAccount;
import com.project.backend.service.RankAccountService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/rank_account")
@SecurityRequirement(name = "bearerAuth")
public class RankAccountController {
    private RankAccountService rankAccountService;

    @PostMapping
    public ResponseEntity<RankAccountDto> createRankAccount(@RequestBody RankAccountDto rankAccountDto){
        RankAccountDto savedRankAccount = rankAccountService.createRankAccount(rankAccountDto);
        return new ResponseEntity<>(savedRankAccount, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<RankAccountDto> getRankAccountById(@PathVariable("id") Long id){
        RankAccountDto rankAccountDto = rankAccountService.getRankAccountById(id);
        return ResponseEntity.ok(rankAccountDto);
    }

    @GetMapping
    public ResponseEntity<List<RankAccountDto>> getAllRankAccount(){
        List<RankAccountDto> rankAccountDtos = rankAccountService.getAllRankAccount();
        return ResponseEntity.ok(rankAccountDtos);
    }

    @PutMapping("{id}")
    public ResponseEntity<RankAccountDto> updateRankAccount(@PathVariable("id") Long id, @RequestBody RankAccountDto rankAccountDto){
        RankAccountDto newRankAccountDto = rankAccountService.updateRankAccount(id, rankAccountDto);
        return new ResponseEntity<>(newRankAccountDto, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity<String> deleteRankAccountById(@PathVariable("id") Long id){
        rankAccountService.deleteRankAccount(id);
        return ResponseEntity.ok("Rank type deleted successfully");
    }
}
