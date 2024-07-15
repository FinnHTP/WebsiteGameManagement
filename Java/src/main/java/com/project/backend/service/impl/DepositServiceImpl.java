package com.project.backend.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.backend.dto.DepositDto;
import com.project.backend.entity.Deposit;
import com.project.backend.exception.ResourceNotFoundException;
import com.project.backend.mapper.DepositMapper;
import com.project.backend.repository.DepositRepository;
import com.project.backend.service.DepositService;

@Service
public class DepositServiceImpl implements DepositService{
    @Autowired
    private DepositRepository depositRepository;

    @Override
    public DepositDto createdeposit(DepositDto Dto) {
        Deposit deposit = DepositMapper.mapToEntity(Dto);
        Deposit savedDeposit = depositRepository.save(deposit);
        return DepositMapper.mapToDTO(savedDeposit);
    }

    @Override
    public DepositDto getdepositById(Long depositId) {
        Deposit deposit = depositRepository.findById(depositId).orElseThrow(() -> new ResourceNotFoundException("Deposit is not found with " + depositId));
        return DepositMapper.mapToDTO(deposit);
    }

    @Override
    public List<DepositDto> getAlldeposit() {
        List<Deposit> deposits = depositRepository.findAll();
        return deposits.stream().map((deposit) -> DepositMapper.mapToDTO(deposit)).collect(Collectors.toList());
    }

    @Override
    public DepositDto UpdateDeposit(Long depositId, DepositDto updatedDepositDto) {
       Deposit deposit = depositRepository.findById(depositId).orElseThrow(() -> new ResourceNotFoundException("Deposit is not found with " + depositId));
        deposit.setAccount(updatedDepositDto.getAccount());
        deposit.setMoney(updatedDepositDto.getMoney());
        deposit.setTxnRef(updatedDepositDto.getTxnRef());
        Deposit savedDeposit = depositRepository.save(deposit);
        return DepositMapper.mapToDTO(savedDeposit);
    }

    @Override
    public void deleteDeposit(Long depositId) {
        Deposit deposit = depositRepository.findById(depositId).orElseThrow(() -> new ResourceNotFoundException("Deposit is not found with " + depositId));
        depositRepository.delete(deposit);
    }

    @Override
    public List<DepositDto> GetAllDepositById(Long accountId) {
        // TODO Auto-generated method stub
        List<Deposit> deposits = depositRepository.findListById(accountId);
        return deposits.stream().map((deposit) -> DepositMapper.mapToDTO(deposit)).collect(Collectors.toList());
    }

}
