package com.example.Task.service;

import com.example.Task.entity.mysql.MySqlEmployee;
import com.example.Task.entity.oracle.OracleEmployee;
import com.example.Task.repo.mysql.MySqlEmployeeRepository;
import com.example.Task.repo.oracle.OracleEmployeeRepository;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import technology.tabula.ObjectExtractor;
import technology.tabula.Page;
import technology.tabula.PageIterator;
import technology.tabula.Table;
import technology.tabula.extractors.SpreadsheetExtractionAlgorithm;
import technology.tabula.RectangularTextContainer;
import org.apache.poi.ss.usermodel.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {

    @Autowired
    private OracleEmployeeRepository oracleRepo;

    @Autowired
    private MySqlEmployeeRepository mysqlRepo;

    @Autowired
    private org.springframework.core.env.Environment env;

    public String processFile(MultipartFile file) throws Exception {
        return readFile(file);
    }

    public String readFile(MultipartFile multipartFile) throws IOException, TesseractException {
        if (multipartFile.getContentType() == null) {
            return "Unsupported file type";
        }

        String type = multipartFile.getContentType().toLowerCase();

        if (type.startsWith("image/")) {
            return processImage(multipartFile);
        } else if (type.equals("application/pdf")) {
            return processPdf(multipartFile);
        } else if (type.equals("application/vnd.ms-excel") ||
                type.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return processExcel(multipartFile);
        }

        // fallback: try treating as excel (some clients send different content-type)
        if (multipartFile.getOriginalFilename() != null &&
                (multipartFile.getOriginalFilename().toLowerCase().endsWith(".xls") ||
                        multipartFile.getOriginalFilename().toLowerCase().endsWith(".xlsx"))) {
            return processExcel(multipartFile);
        }

        return "Unsupported file type: " + type;
    }

    // ---------------- IMAGE ----------------
    private String processImage(MultipartFile multipartFile) throws IOException, TesseractException {
        String datapath = env.getProperty("app.tesseract.datapath");
        String language = env.getProperty("app.tesseract.language", "eng");

        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        tesseract.setLanguage("eng");

        if (datapath != null) tesseract.setDatapath(datapath);
        tesseract.setLanguage(language);

        BufferedImage bufferedImage = ImageIO.read(multipartFile.getInputStream());
        return tesseract.doOCR(bufferedImage);
    }

    // ---------------- PDF ----------------
    private String processPdf(MultipartFile multipartFile) {
        StringBuilder sb = new StringBuilder();

        try (PDDocument document = PDDocument.load(multipartFile.getInputStream())) {
            ObjectExtractor extractor = new ObjectExtractor(document);
            SpreadsheetExtractionAlgorithm sea = new SpreadsheetExtractionAlgorithm();
            PageIterator pages = extractor.extract();

            while (pages.hasNext()) {
                Page page = pages.next();
                List<Table> tables = sea.extract(page);

                for (Table table : tables) {
                    for (List<RectangularTextContainer> row : table.getRows()) {
                        List<String> cells = new ArrayList<>();
                        for (RectangularTextContainer cell : row) {
                            String text = cell.getText().trim();
                            cells.add(text);
                        }

                        if (cells.size() >= 1) {
                            sb.append(String.join(" | ", cells)).append("\n");

                            // Skip header row
                            if (cells.get(0).equalsIgnoreCase("ID") || cells.get(0).matches("(?i)id.*")) {
                                continue;
                            }

                            OracleEmployee emp = new OracleEmployee();
                            try {
                                if (cells.size() >= 2) emp.setName(cells.get(1));
                                if (cells.size() >= 3) emp.setAge(Integer.parseInt(cells.get(2)));
                                if (cells.size() >= 4) emp.setDepartment(cells.get(3));
                                if (cells.size() >= 5) emp.setSalary(Double.parseDouble(cells.get(4)));
                            } catch (Exception ex) {
                                System.out.println("Skipping row due to parse error: " + cells);
                            }

                            oracleRepo.save(emp);
                        }
                    }

                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error processing PDF", e);
        }

        return sb.toString() + "\n(Table stored in Oracle)";
    }

    // ---------------- EXCEL ----------------
    private String processExcel(MultipartFile multipartFile) {
        StringBuilder sb = new StringBuilder();

        try (Workbook workbook = WorkbookFactory.create(multipartFile.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);

            boolean headerFound = false; // flag for header
            for (Row row : sheet) {
                if (row == null) continue;

                // Read fixed 5 columns (ID, Name, Age, Department, Salary)
                List<String> cells = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    Cell cell = row.getCell(i, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                    cells.add(getCellValue(cell));
                }

                // Skip completely empty rows
                if (cells.stream().allMatch(String::isEmpty)) {
                    continue;
                }

                // Detect header row (first column = "ID")
                if (!headerFound && cells.get(0).equalsIgnoreCase("ID")) {
                    headerFound = true;
                    sb.append(String.join(" | ", cells)).append("\n"); // still print header
                    continue; // don't insert header into DB
                }

                // If header not yet found, skip these rows (garbage rows)
                if (!headerFound) {
                    continue;
                }

                sb.append(String.join(" | ", cells)).append("\n");

                // Save employee data
                MySqlEmployee emp = new MySqlEmployee();
                try {
                    if (!cells.get(1).isEmpty()) emp.setName(cells.get(1));
                    if (!cells.get(2).isEmpty()) emp.setAge(Integer.parseInt(cells.get(2)));
                    if (!cells.get(3).isEmpty()) emp.setDepartment(cells.get(3));
                    if (!cells.get(4).isEmpty()) emp.setSalary(Double.parseDouble(cells.get(4)));
                } catch (Exception ex) {
                    System.out.println("Skipping row due to parse error: " + cells);
                    continue;
                }

                mysqlRepo.save(emp);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error processing Excel", e);
        }

        return sb.toString() + "\n(Table stored in MySQL)";
    }

    // Helper method to read cell values correctly
    private String getCellValue(Cell cell) {
        if (cell == null) return "";
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    double d = cell.getNumericCellValue();
                    // format without .0 if it's an integer
                    if (d == Math.floor(d)) {
                        return String.valueOf((long) d);
                    }
                    return String.valueOf(d);
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                try {
                    return cell.getStringCellValue();
                } catch (Exception e) {
                    return String.valueOf(cell.getNumericCellValue());
                }
            default:
                return "";
        }
    }
}