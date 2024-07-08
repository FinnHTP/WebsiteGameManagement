package com.project.backend.service.impl;

import com.project.backend.entity.Game;
import com.project.backend.entity.OrderDetail;
import com.project.backend.repository.OrderDetailRepository;
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
public class ExcelOrderDetaiService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    public void exportToExcelOderDetail(HttpServletResponse response) throws IOException {
        List<OrderDetail> orderDetails = orderDetailRepository.findAll();

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Oder Detail");
        HSSFRow row = sheet.createRow(0);

        row.createCell(0).setCellValue("ID");
        row.createCell(1).setCellValue("Price");




        int dataRowIndex = 1;
        for (OrderDetail orderDetail : orderDetails) {
            HSSFRow dataRow = sheet.createRow(dataRowIndex);
            dataRow.createCell(0).setCellValue(orderDetail.getId());
            dataRow.createCell(1).setCellValue(orderDetail.getPrice());
            dataRowIndex ++;

        }
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

    }
}
