package com.project.backend.service.impl;

import com.project.backend.dto.RankAccountDto;
import com.project.backend.entity.RankAccount;
import com.project.backend.exception.ResourceNotFoundException;
import com.project.backend.mapper.RankTypeMapper;
import com.project.backend.repository.RankAccountRepository;
import com.project.backend.service.RankAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RankAccountServiceImpl implements RankAccountService {
    private RankAccountRepository rankAccountRepository;

    @Override
    public RankAccountDto createRankAccount(RankAccountDto rankAccountDto) {
        RankAccount rankAccount = RankTypeMapper.MapToRankAccount(rankAccountDto);
        RankAccount savedRankAccount = rankAccountRepository.save(rankAccount);
        return RankTypeMapper.MapToRankDto(savedRankAccount);
    }

    @Override
    public RankAccountDto getRankAccountById(Long id) {
        RankAccount rankAccount = rankAccountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Rank type can't be found with given id " + id));
        return RankTypeMapper.MapToRankDto(rankAccount);
    }

    @Override
    public RankAccountDto updateRankAccount(Long id, RankAccountDto rankAccountDto) {
        RankAccount rankAccount = rankAccountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Rank type can't be found with given id " + id));
        rankAccount.setId(rankAccountDto.getId());
        rankAccount.setName(rankAccountDto.getName());
        rankAccount.setPrice(rankAccountDto.getPrice());
        RankAccount updatedRankAccount = rankAccountRepository.save(rankAccount);
        return RankTypeMapper.MapToRankDto(updatedRankAccount);
    }

    @Override
    public List<RankAccountDto> getAllRankAccount() {
        List<RankAccount> rankAccounts = rankAccountRepository.findAll();
        return rankAccounts.stream().map((rankAccount) -> RankTypeMapper.MapToRankDto(rankAccount)).collect(Collectors.toList());
    }

    @Override
    public void deleteRankAccount(Long id) {
        RankAccount rankAccount = rankAccountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Rank type can't be found with given id " + id));
        rankAccountRepository.deleteById(id);
    }
}
