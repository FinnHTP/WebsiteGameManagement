package com.project.backend.controller;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.backend.config.VNPayConfig;
import com.project.backend.dto.AccountDto;
import com.project.backend.entity.Account;
import com.project.backend.repository.AccountRepository;
import com.project.backend.service.AccountService;
import com.project.backend.service.DepositService;
import com.project.backend.service.PaymentService;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    private DepositService depositService;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public Map<String, String> createPayment(@RequestParam String amount,
                                             @RequestParam(required = false) String bankCode,
                                             @RequestParam(required = false) String language,
                                             @RequestParam Long accountId, 
                                             HttpServletRequest req) throws Exception {
        return paymentService.createPayment(amount, bankCode, language, accountId, req);
    }

    @PostMapping("/save-payment")
    public Map<String, String> createPayment(@RequestParam String amount,
                                             @RequestParam Long bookingId,
                                             @RequestParam Long accountId,
                                             HttpServletRequest req) throws Exception {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        String vnp_TxnRef = VNPayConfig.getRandomNumber(8);
        Double amountValue = Double.parseDouble(amount) * 100;
        Date createDate = new Date(); // or fetch from your specific logic
        Double accountBalance = account.getAccountBalance();
        Double totalMoney = accountBalance + amountValue;
        account.setAccountBalance(totalMoney);
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountBalance(accountBalance);
        accountService.updateAccountBalance(accountId, accountDto);
        System.out.println(accountDto.getAccountBalance());              
        paymentService.savePayment(vnp_TxnRef, amount, createDate, account);
        // Build and return response as needed
        // Example response map
        Map<String, String> response = Map.of("code", "00", "message", "success");
        return response;
    }
}
