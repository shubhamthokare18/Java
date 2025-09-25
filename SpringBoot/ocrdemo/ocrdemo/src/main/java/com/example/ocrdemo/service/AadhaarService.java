package com.example.ocrdemo.service;

import com.example.ocrdemo.entity.AadhaarDetails;
import com.example.ocrdemo.parser.AadhaarParser;
import com.example.ocrdemo.repo.AadhaarRepository;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class AadhaarService {

    private final AadhaarRepository repository;

    public AadhaarService(AadhaarRepository repository) {
        this.repository = repository;
    }

    public String extractTextFromImage(MultipartFile file) throws IOException {
        File tempFile = File.createTempFile("ac1", ".png");
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(file.getBytes());
        }

        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata"); // Path to tessdata folder
        tesseract.setLanguage("eng");

        try {
            return tesseract.doOCR(tempFile);
        } catch (TesseractException e) {
            throw new RuntimeException("OCR failed", e);
        } finally {
            tempFile.delete();
        }
    }

    public AadhaarDetails saveFromOcrText(String ocrText) {
        AadhaarDetails details = AadhaarParser.parse(ocrText);
        return repository.save(details);
    }
}