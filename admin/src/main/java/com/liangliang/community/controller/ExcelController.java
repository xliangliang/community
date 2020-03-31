package com.liangliang.community.controller;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Controller
public class ExcelController {

    private static final String EXCEL_PATH = "E:\\Liangliang\\Temp";

    @RequestMapping(name = "/api/export", method = RequestMethod.GET)
    public void export() {
        //excel 对象
        HSSFWorkbook workbook = new HSSFWorkbook();
        //工作表对象
        HSSFSheet sheet = workbook.createSheet("亮亮");
        //行对象
        HSSFRow row = sheet.createRow(0);
        //单元格
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("姓名");
        cell.setCellValue("年龄");
        cell.setCellValue("性别");
        row = sheet.createRow(1);
        cell = row.createCell(1);
        cell.setCellValue("亮亮");
        cell.setCellValue(18);
        cell.setCellValue("男");
        String uuidName = UUID.randomUUID().toString();
        try {
            FileOutputStream fops = new FileOutputStream(EXCEL_PATH + File.separator + uuidName + ".xls");
            workbook.write(fops);
            fops.flush();
            fops.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
