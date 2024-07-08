package com.project.backend.service.impl;

import com.project.backend.entity.Game;
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
public class ExcelGameService {
    @Autowired
    private GameRepository gameRepository;
    public void exportToExcel(HttpServletResponse response) throws IOException {
        List<Game> games = gameRepository.findAll();

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Games");
        HSSFRow row = sheet.createRow(0);

        row.createCell(0).setCellValue("Name");
        row.createCell(1).setCellValue("Description");
        row.createCell(2).setCellValue("Status");
        row.createCell(3).setCellValue("Price");
        row.createCell(4).setCellValue("Date");
        row.createCell(5).setCellValue("version");



        int dataRowIndex = 1;
        for (Game game : games) {
            HSSFRow dataRow = sheet.createRow(dataRowIndex);
            dataRow.createCell(0).setCellValue(game.getName());
            dataRow.createCell(1).setCellValue(game.getDescription());
            dataRow.createCell(2).setCellValue(game.getStatus());
            dataRow.createCell(3).setCellValue(game.getPriceGame());
            dataRow.createCell(4).setCellValue(game.getReleaseDate());
            dataRow.createCell(5).setCellValue(game.getVersion());
            dataRowIndex ++;

        }
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

    }

}
