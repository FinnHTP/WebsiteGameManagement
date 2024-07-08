package com.project.backend.service.impl;

import com.project.backend.entity.GameSystemRequirement;
import com.project.backend.entity.User;
import com.project.backend.repository.GameSystemRequirementRepository;
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
public class ExcelGameSySService {
    @Autowired
    private GameSystemRequirementRepository gameSystemRequirementRepository;
    public void exportToExcelGameSyS(HttpServletResponse response) throws IOException {
        List<GameSystemRequirement> gameSystemRequirements = gameSystemRequirementRepository.findAll();

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("GameSystemRequirement");
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("Id");
        row.createCell(1).setCellValue("Card");
        row.createCell(2).setCellValue("Memory");
        row.createCell(3).setCellValue("Os");
        row.createCell(4).setCellValue("Procecsor");
        row.createCell(5).setCellValue("Storage");


        int dataRowIndex = 1;
        for (GameSystemRequirement gameSystemRequirement : gameSystemRequirements) {
            HSSFRow dataRow = sheet.createRow(dataRowIndex);
            dataRow.createCell(0).setCellValue(gameSystemRequirement.getId());
            dataRow.createCell(1).setCellValue(gameSystemRequirement.getCard());
            dataRow.createCell(2).setCellValue(gameSystemRequirement.getMemory());
            dataRow.createCell(3).setCellValue(gameSystemRequirement.getOs());
            dataRow.createCell(4).setCellValue(Arrays.toString(gameSystemRequirement.getProccessor().toCharArray()));
            dataRow.createCell(5).setCellValue(gameSystemRequirement.getStorage());

            dataRowIndex ++;

        }
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

    }
}
