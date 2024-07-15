package com.project.backend.service;

import java.util.List;

import com.project.backend.dto.DepositDto;

public interface DepositService {
    DepositDto createdeposit(DepositDto Dto);
    DepositDto getdepositById(Long depositId);
    List<DepositDto> getAlldeposit();
    DepositDto UpdateDeposit(Long depositId ,DepositDto updatedDepositDto);
    void deleteDeposit(Long depositId);
    List<DepositDto> GetAllDepositById(Long accountId);
}
