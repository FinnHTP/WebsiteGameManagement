package com.project.backend.mapper;

import com.project.backend.dto.DepositDto;
import com.project.backend.entity.Deposit;

public class DepositMapper {
    public static Deposit mapToEntity(DepositDto depositDto){
        Deposit deposit = new Deposit();
        deposit.setId(depositDto.getId());
        deposit.setAccount(depositDto.getAccount());
        deposit.setMoney(depositDto.getMoney());
        deposit.setTxnRef(depositDto.getTxnRef());
        return deposit;
    }

    public static DepositDto mapToDTO(Deposit deposit){
        DepositDto depositDto = new DepositDto();
        depositDto.setId(deposit.getId());
        depositDto.setAccount(deposit.getAccount());
        depositDto.setMoney(deposit.getMoney());
        depositDto.setTxnRef(deposit.getTxnRef());
        return depositDto;
    }
}
