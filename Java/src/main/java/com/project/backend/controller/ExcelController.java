package com.project.backend.controller;

import com.project.backend.service.impl.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("*")
@RestController
@RequestMapping("api/excel")
public class ExcelController {
    @Autowired
    private ExcelGameService excelService;
    @Autowired
    private ExcelAccountService excelAccountService;
    @Autowired
    private ExcelUserService excelUserService;
    @Autowired
    private ExcelGameSySService excelGameSySService;
    @Autowired
    private ExcelRankTypeService excelRankTypeService;
    @Autowired
    private ExcelOrderDetaiService excelOrderDetaiService;

    @GetMapping("/game")
    public void generateExcel(HttpServletResponse response) throws Exception {

        response.setContentType("application/vnd.ms-excel");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Excel.xls";
        response.setHeader(headerKey, headerValue);
        excelService.exportToExcel(response);
    }

    @GetMapping("/account")
    public void excelaccount(HttpServletResponse response) throws Exception {

        response.setContentType("application/vnd.ms-excel");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Excel.xls";
        response.setHeader(headerKey, headerValue);
        excelAccountService.AccourtExport(response);
    }

    @GetMapping("/user")
    public void ExcelUser(HttpServletResponse response) throws Exception {
        response.setContentType("application/vnd.ms-excel");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Excel.xls";
        response.setHeader(headerKey, headerValue);
        excelUserService.exportToExcelUser(response);
    }


    @GetMapping("/gamesys")
    public void ExcelGameSys(HttpServletResponse response) throws Exception {
        response.setContentType("application/vnd.ms-excel");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Excel.xls";
        response.setHeader(headerKey, headerValue);
        excelGameSySService.exportToExcelGameSyS(response);
    }

    @GetMapping("/OderDetail")
    public void ExcelOderDetail(HttpServletResponse response) throws Exception {
        response.setContentType("application/vnd.ms-excel");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Excel.xls";
        response.setHeader(headerKey, headerValue);
        excelOrderDetaiService.exportToExcelOderDetail(response);
    }

    @GetMapping("/RankType")
    public void ExcelRankTye(HttpServletResponse response) throws Exception {
        response.setContentType("application/vnd.ms-excel");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Excel.xls";
        response.setHeader(headerKey, headerValue);
        excelRankTypeService.exportToExcelRanktype(response);
    }

}

