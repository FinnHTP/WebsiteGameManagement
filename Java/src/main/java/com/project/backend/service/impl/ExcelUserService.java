package com.project.backend.service.impl;


import com.project.backend.entity.Game;
import com.project.backend.entity.User;
import com.project.backend.repository.UserRepository;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
@Service
public class ExcelUserService {
    @Autowired
    private UserRepository userRepository;
    public void exportToExcelUser(HttpServletResponse response) throws IOException {
        List<User> users = userRepository.findAll();

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Users");
        HSSFRow row = sheet.createRow(0);

        row.createCell(0).setCellValue("Id");
        row.createCell(1).setCellValue("FistName");
        row.createCell(2).setCellValue("LastName");
        row.createCell(3).setCellValue("SDT");
        row.createCell(4).setCellValue("Avatar");



        int dataRowIndex = 1;
        for (User user : users) {
            HSSFRow dataRow = sheet.createRow(dataRowIndex);
            dataRow.createCell(0).setCellValue(user.getId());
            dataRow.createCell(1).setCellValue(user.getFirstName());
            dataRow.createCell(2).setCellValue(user.getLastName());
            dataRow.createCell(3).setCellValue(user.getSdt());
            dataRow.createCell(4).setCellValue(Arrays.toString(user.getAvatar()));

            dataRowIndex ++;

        }
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

    }

}
