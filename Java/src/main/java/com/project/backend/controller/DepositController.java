package com.project.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.backend.dto.DepositDto;
import com.project.backend.service.DepositService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/deposits")
@SecurityRequirement(name = "bearerAuth")
public class DepositController {
    @Autowired
    private DepositService depositService;

    @GetMapping
    public ResponseEntity<List<DepositDto>> getListDeposit(){
        List<DepositDto> deposits = depositService.getAlldeposit();
        return ResponseEntity.ok(deposits);
    }

    @PostMapping
    public ResponseEntity<DepositDto> createDeposit(@RequestBody DepositDto depositDto){
        DepositDto savedDepositDto = depositService.createdeposit(depositDto);
        return new ResponseEntity<>(savedDepositDto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<List<DepositDto>> getListDepositById(@PathVariable("id") Long accountId){
        List<DepositDto> deposits = depositService.GetAllDepositById(accountId);
        return ResponseEntity.ok(deposits);
    }

    @PutMapping("{id}")
    public ResponseEntity<DepositDto> updateDeposit(@PathVariable("id") Long depositId, @RequestBody DepositDto depositDto){
        DepositDto updateddepositDto = depositService.UpdateDeposit(depositId, depositDto);
        return new ResponseEntity<>(updateddepositDto, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDeposit(@PathVariable("id") Long depositId){
        depositService.deleteDeposit(depositId);
        return ResponseEntity.ok("Delete Successfully");
    }

}
