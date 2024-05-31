package com.project.backend.mapper;

import com.project.backend.dto.RankAccountDto;
import com.project.backend.entity.RankAccount;

public class RankTypeMapper {
    public static RankAccountDto MapToRankDto(RankAccount rankAccount){
        RankAccountDto rankAccountDto = new RankAccountDto();
        rankAccountDto.setId(rankAccount.getId());
        rankAccountDto.setName(rankAccount.getName());
        rankAccountDto.setPrice(rankAccount.getPrice());
        return rankAccountDto;
    }

    public static RankAccount MapToRankAccount(RankAccountDto rankAccountDto){
        RankAccount rankAccount = new RankAccount();
        rankAccount.setId(rankAccountDto.getId());
        rankAccount.setName(rankAccountDto.getName());
        rankAccount.setPrice(rankAccountDto.getPrice());
        return rankAccount;
    }
}
