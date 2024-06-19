package com.project.backend.service;

import com.project.backend.dto.RankAccountDto;

import java.util.List;

public interface RankAccountService {
    RankAccountDto createRankAccount(RankAccountDto rankAccountDto);
    RankAccountDto getRankAccountById(Long id);
    RankAccountDto updateRankAccount(Long id, RankAccountDto rankAccountDto);
    List<RankAccountDto> getAllRankAccount();
    void deleteRankAccount(Long id);
}
