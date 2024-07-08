package com.project.backend.controller;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class BillController {
    @GetMapping("/api/bill/{orderId}")
    public void generateInvoice(@PathVariable Long orderId, HttpServletResponse response) {
        try {
            // Thiết lập kiểu content của response là PDF
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=invoice.pdf");

            // Tạo một document PDF mới
            Document document = new Document();
            // Ghi nội dung vào document PDF
            PdfWriter.getInstance(document, response.getOutputStream());

            document.open();
            document.add(new Paragraph("Hóa đơn cho đơn hàng số #" + orderId));
            document.add(new Paragraph("Thông tin chi tiết hóa đơn sẽ được thêm vào đây..."));
            document.close();

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            // Xử lý lỗi nếu cần thiết
        }
    }
}
