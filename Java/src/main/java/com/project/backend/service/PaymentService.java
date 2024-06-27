package com.project.backend.service;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

import com.project.backend.config.VNPayConfig;
import com.project.backend.dto.AccountDto;
import com.project.backend.entity.Account;
import com.project.backend.entity.Deposit;
import com.project.backend.entity.Game;
import com.project.backend.entity.OrderDetail;
import com.project.backend.repository.AccountRepository;
import com.project.backend.repository.DepositRepository;
import com.project.backend.repository.OrderDetailRepository;

@Service
public class PaymentService {
    @Autowired
    private DepositRepository depositRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountService accountService;

    public static String vnp_PayUrl = "https://sandbox.vnpayment.vn/paymentv2/vpcpay.html";
    public static String vnp_ReturnUrl = "http://localhost:3000/profile";
    public static String vnp_TmnCode = "HEBHXO7Q";
    public static String vnp_HashSecret = "4DH3NWFTQRZWT9ZZDC9R17RLN31A74E5";

    public Map<String, String> createPayment(String amountStr, String bankCode, String language, Long accountId, HttpServletRequest req) throws Exception {
        String vnp_Version = "2.1.0";
        String vnp_Command = "pay";
        String orderType = "other";
        long amount = Integer.parseInt(amountStr) * 100L;
        String vnp_TxnRef = VNPayConfig.getRandomNumber(8);
        String vnp_IpAddr = VNPayConfig.getIpAddress(req);

        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", vnp_Version);
        vnp_Params.put("vnp_Command", vnp_Command);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf(amount));
        vnp_Params.put("vnp_CurrCode", "VND");

        if (bankCode != null && !bankCode.isEmpty()) {
            vnp_Params.put("vnp_BankCode", bankCode);
        }
        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        vnp_Params.put("vnp_OrderInfo", "Thanh toan don hang:" + vnp_TxnRef);
        vnp_Params.put("vnp_OrderType", orderType);

        String locale = (language != null && !language.isEmpty()) ? language : "vn";
        vnp_Params.put("vnp_Locale", locale);
        vnp_Params.put("vnp_ReturnUrl", vnp_ReturnUrl);
        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

        cld.add(Calendar.MINUTE, 15);
        String vnp_ExpireDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

        List<String> fieldNames = new ArrayList<>(vnp_Params.keySet());
        Collections.sort(fieldNames);

        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        for (String fieldName : fieldNames) {
            String fieldValue = vnp_Params.get(fieldName);
            if (fieldValue != null && !fieldValue.isEmpty()) {
                hashData.append(fieldName).append('=').append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII));
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII)).append('=').append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII));
                if (!fieldName.equals(fieldNames.get(fieldNames.size() - 1))) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }

        String queryUrl = query.toString();
        String vnp_SecureHash = VNPayConfig.hmacSHA512(vnp_HashSecret, hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        String paymentUrl = vnp_PayUrl + "?" + queryUrl;

        Map<String, String> response = new HashMap<>();
        response.put("code", "00");
        response.put("message", "success");
        response.put("data", paymentUrl);

        return response;
    }

    public void savePayment(String vnp_TxnRef, String amount, Date createDate, Account account) {
        account = accountRepository.findById(account.getId()).orElseThrow(() -> new RuntimeException(("Account not found")));
        Deposit deposit = new Deposit();
        deposit.setTxnRef(vnp_TxnRef);
        deposit.setAccount(account);
        deposit.setMoney(Double.parseDouble(amount));
        depositRepository.save(deposit);
        AccountDto accountDto = new AccountDto();
        accountDto.setId(3L);
        accountDto.setAccountBalance(Double.parseDouble(amount));
        accountService.updateAccountBalance(account.getId(), accountDto);
    }
}
