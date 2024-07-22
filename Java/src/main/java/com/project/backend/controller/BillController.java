package com.project.backend.controller;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceCmyk;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.canvas.draw.SolidLine;
import com.itextpdf.kernel.pdf.xobject.PdfImageXObject;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.LineSeparator;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.*;
import com.itextpdf.layout.renderer.DocumentRenderer;
import com.project.backend.dto.GameDto;
import com.project.backend.dto.OrderDto;
import com.project.backend.entity.Order;
import com.project.backend.service.GameService;
import com.project.backend.service.OrderService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.itextpdf.kernel.pdf.PdfName.Event;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/invoice")
public class BillController {
    @Autowired
    private GameService gameService;
    @Autowired
    private OrderService orderservice;

    @GetMapping("/{orderId}")
    public ResponseEntity<byte[]> generateInvoice(@PathVariable Long orderId,HttpServletResponse response, Long gameId) throws URISyntaxException {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter writer = new PdfWriter(baos);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf, PageSize.A5);

            document.setMargins(36, 36, 36, 36);
            document.setBackgroundColor(new DeviceRgb(255,249,214));
            pdf.addEventHandler(PdfDocumentEvent.END_PAGE, new PdfBackgroundEventHandler());
            document.setBorder(new SolidBorder(new DeviceRgb(153, 153, 153), 2));
            PdfFont font = PdfFontFactory.createFont();
            OrderDto orderDto = orderservice.getOrderById(orderId);

            String logoPath = "images/loo.jpg";

            Image logo = new Image(ImageDataFactory.create(logoPath));
            logo.setBorder(new SolidBorder(new DeviceRgb(153, 153, 153), 2));
            logo.setWidth(100);
            logo.setHeight(50);
            document.add(logo);
            Paragraph title = new Paragraph("Invoice: " + orderDto.getId())
                    .setFont(font)
                    .setFontSize(22)
                    .setFontColor(Color.BLACK)
                    .setTextAlignment(TextAlignment.CENTER);
            document.add(title);
            document.add(new LineSeparator(new SolidLine()));

            document.add(new Paragraph());
            GameDto gamedto = gameService.getOrderByGameId(orderId);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            DecimalFormat decimalFormat = new DecimalFormat("#,###");
            String formattedPrice = decimalFormat.format(gamedto.getPriceGame());
            Paragraph gameInfo = new Paragraph()
                    .setFontColor(Color.BLACK)
                    .setFontSize(18)
                    .addTabStops(new TabStop(300, TabAlignment.CENTER))
                    .add(new Text("ID Game: ")
                            .setBold())
                    .add(new Tab())
                    .add(gamedto.getId().toString())
                    .add(new Text("\nGame Name: ")
                            .setBold())
                    .add(new Tab())
                    .add(gamedto.getName())
                    .add(new Text("\nPrice: ")
                            .setBold())
                    .add(new Tab())
                    .add(formattedPrice + " VND")
                    .add(new Text("\nDate of invoice creation: ")
                            .setBold())
                    .add(new Tab())
                    .add(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            Image image = null;
            String imageFileName = gameService.getImageData(gamedto.getId());
            if (imageFileName != null) {
                String imagePath = "images/" + imageFileName;
                try {
                    image = new Image(ImageDataFactory.create(imagePath));
                    image.setWidth(180);
                    image.setHeight(150);
                } catch (IOException e) {
                    throw new IOException("Failed to create ImageData from image path", e);
                }
            }
            Div div = new Div()
                    .setBackgroundColor(new DeviceRgb(255, 249, 214))
                    .setBorder(new SolidBorder(new DeviceRgb(153, 153, 153), 2))
                    .setPadding(10);
            div.add(gameInfo);
            if (image != null) {
                div.add(image);
            }
            gameInfo.setBorder(new SolidBorder(new DeviceRgb(153, 153, 153), 2));
            document.add(div);

///////////////////////////////////////////////////////////////////////////////////////////////////////
            document.add(new Paragraph("--------------------------------------------------------"));

            Double totalAmount = gamedto.getPriceGame();
            Paragraph total = new Paragraph("TotalAmount: $" + totalAmount)
                    .setFont(font)
                    .setMarginTop(20);
            document.add(total);
            document.close();
            byte[] pdfBytes = baos.toByteArray();
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, "application/pdf");
            headers.setContentDispositionFormData("attachment", "invoice.pdf");

            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    private static class PdfBackgroundEventHandler implements IEventHandler {

        @Override
        public void handleEvent(com.itextpdf.kernel.events.Event event) {
            PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
            com.itextpdf.kernel.pdf.PdfDocument pdfDoc = docEvent.getDocument();
            com.itextpdf.kernel.pdf.PdfPage page = docEvent.getPage();

            com.itextpdf.kernel.pdf.canvas.PdfCanvas canvas = new com.itextpdf.kernel.pdf.canvas.PdfCanvas(
                    page.newContentStreamBefore(), page.getResources(), pdfDoc);
            Color backgroundColor = new DeviceRgb(255, 255, 204);
            canvas.rectangle(0, 0, page.getPageSize().getWidth(), page.getPageSize().getHeight())
                    .setColor(backgroundColor, true)
                    .fill();
            canvas.release();
        }
    }
}
