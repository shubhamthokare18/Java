package com.example.tesseract.controller;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

//package com.example.tesseract.controller;
//
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//
//@RestController
//@RequestMapping("/excel")
//public class ExcelController {
//
//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadExcel(@RequestParam("file") MultipartFile file) {
//        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
//
//            Sheet sheet = workbook.getSheetAt(0);
//
//            for (Row row : sheet) {
//                for (Cell cell : row) {
//                    switch (cell.getCellType()) {
//                        case STRING -> System.out.print(cell.getStringCellValue() + "\t");
//                        case NUMERIC -> System.out.print(cell.getNumericCellValue() + "\t");
//                        case BOOLEAN -> System.out.print(cell.getBooleanCellValue() + "\t");
//                        default -> System.out.print("\t");
//                    }
//                }
//                System.out.println();
//            }
//
//            return ResponseEntity.ok("Excel file processed successfully. Check IntelliJ console.");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ResponseEntity.status(500).body("Error reading Excel file.");
//        }
//    }
//}
@RestController
@RequestMapping("/excel")
public class ExcelController{
    @PostMapping("/upload")
    public ResponseEntity<String> uploadExcel(@RequestParam("file")MultipartFile file){
        try(Workbook workbook=new XSSFWorkbook(file.getInputStream())){
            Sheet sheet=workbook.getSheetAt(0);
            for (Row row:sheet){
                for (Cell cell:row){
                    switch (cell.getCellType()){
                        case STRING -> System.out.print(cell.getStringCellValue()+"\t");
                        case NUMERIC -> System.out.print(cell.getNumericCellValue()+"\t");
                        case BOOLEAN -> System.out.print(cell.getBooleanCellValue()+"\t");
                        default -> System.out.print("\t");
                    }
                }
                System.out.println();
            }
            return ResponseEntity.ok("Excel file processed successfully. Check IntelliJ console.");
        }catch (IOException e){
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error reading Excel file.");
        }
    }
}