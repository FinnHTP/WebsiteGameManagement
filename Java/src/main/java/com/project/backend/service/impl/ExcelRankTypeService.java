package com.project.backend.service.impl;

import com.project.backend.entity.OrderDetail;
import com.project.backend.entity.RankAccount;
import com.project.backend.repository.RankAccountRepository;
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
public class ExcelRankTypeService {
    @Autowired
    private RankAccountRepository accountRepository;
    public void exportToExcelRanktype(HttpServletResponse response) throws IOException {
        List<RankAccount> accountList = accountRepository.findAll();

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Rank Account");
        HSSFRow row = sheet.createRow(0);

        row.createCell(0).setCellValue("ID");
        row.createCell(1).setCellValue("Name");
        row.createCell(2).setCellValue("Price");




        int dataRowIndex = 1;
        for (RankAccount account : accountList) {
            HSSFRow dataRow = sheet.createRow(dataRowIndex);
            dataRow.createCell(0).setCellValue(account.getId());
            dataRow.createCell(1).setCellValue(account.getName());
            dataRow.createCell(2).setCellValue(account.getPrice());
            dataRowIndex ++;

        }
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

    }
}
