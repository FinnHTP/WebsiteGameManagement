package com.project.backend.service.impl;

import com.project.backend.entity.Account;
import com.project.backend.entity.Game;
import com.project.backend.repository.AccountRepository;
import com.project.backend.repository.GameRepository;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
public class ExcelAccountService {
    @Autowired
    private AccountRepository accountRepository;
    public void AccourtExport(HttpServletResponse response) throws IOException {
        List<Account> accounts = accountRepository.findAll();

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheets = workbook.createSheet("Account");
        HSSFRow row = sheets.createRow(0);

        row.createCell(0).setCellValue("Id");
        row.createCell(1).setCellValue("Username");
        row.createCell(2).setCellValue("Level");
        row.createCell(3).setCellValue("Password");
        row.createCell(4).setCellValue("Email");
        row.createCell(5).setCellValue("BALANCE");
        row.createCell(6).setCellValue("Name");



        int dataRowIndex = 1;
        for (Account account : accounts) {
            HSSFRow dataRow = sheets.createRow(dataRowIndex);
            dataRow.createCell(0).setCellValue(account.getId());
            dataRow.createCell(1).setCellValue(account.getUsername());
            dataRow.createCell(2).setCellValue(account.getLevel());
            dataRow.createCell(3).setCellValue(account.getPassword());
            dataRow.createCell(4).setCellValue(account.getEmail());
            dataRow.createCell(5).setCellValue(account.getAccountBalance());
            dataRow.createCell(6).setCellValue(String.valueOf(account.getUser()));
            dataRowIndex ++;

        }
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

    }
}
