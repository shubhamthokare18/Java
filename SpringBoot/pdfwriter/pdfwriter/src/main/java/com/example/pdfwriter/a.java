package com.example.pdfwriter;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class a implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(a.class, args);
    }


    public void run(String... args) throws FileNotFoundException {
        Document document = new Document();
        String path = "C:\\Users\\Sreenivas Bandaru\\Desktop\\SpringBoot\\pdfwriter\\pdfwriter\\src\\main\\java\\com\\example\\pdfwriter\\person.pdf";
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        PdfWriter pdfWriter = PdfWriter.getInstance(document, fileOutputStream);
        document.open();

        PdfPTable pdfPTable = new PdfPTable(4);
        List<String> header = List.of("Id", "name", "branch", "department");

        header.forEach(column ->
        {
            Phrase phrase = new Phrase(column);
            PdfPCell pdfPCell = new PdfPCell();
            pdfPCell.setBackgroundColor(Color.CYAN);
            pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            pdfPCell.setVerticalAlignment(Element.ALIGN_CENTER);
            pdfPCell.setPadding(5);
            pdfPCell.setPhrase(phrase);
            pdfPTable.addCell(pdfPCell);
        });

        List<Person> list = new ArrayList<>();
        list.add(new Person(1, "Alice", "Mech", "Java"));
        list.add(new Person(1, "Berlin", "Civil", "Java"));
        list.add(new Person(1, "Charlie", "Elec", "Java"));
        list.add(new Person(1, "David", "CS", "Java"));

        for (Person person : list) {
            PdfPCell pdfPCell1 = new PdfPCell(new Phrase(String.valueOf(person.getId())));
            pdfPTable.addCell(pdfPCell1);

            PdfPCell pdfPCell2 = new PdfPCell(new Phrase(String.valueOf(person.getName())));
            pdfPTable.addCell(pdfPCell2);

            PdfPCell pdfPCell3 = new PdfPCell(new Phrase(String.valueOf(person.getBranch())));
            pdfPTable.addCell(pdfPCell3);

            PdfPCell pdfPCell4 = new PdfPCell(new Phrase(String.valueOf(person.getDepartment())));
            pdfPTable.addCell(pdfPCell4);
        }

        document.add(pdfPTable);
        document.close();

        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("");

        Row row = sheet.createRow(1);

        Cell cell = row.createCell(0);
        cell.setCellValue("");


    }

    @Data
    @AllArgsConstructor
    static
    class Person
    {
        private int id;
        private String name;
        private String branch;
        private String department;
    }
}
