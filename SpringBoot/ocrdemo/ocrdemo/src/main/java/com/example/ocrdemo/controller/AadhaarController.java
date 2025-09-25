package com.example.ocrdemo.controller;

import com.example.ocrdemo.entity.AadhaarDetails;
import com.example.ocrdemo.service.AadhaarService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
@RequestMapping("/aadhaar")
public class AadhaarController {

    private final AadhaarService service;

    public AadhaarController(AadhaarService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public AadhaarDetails save(@RequestParam("file") MultipartFile file) throws IOException {
        // 1️⃣ Extract text from image using Tesseract
        String ocrText = service.extractTextFromImage(file);

        // 2️⃣ Parse and save to DB
        return service.saveFromOcrText(ocrText);
    }
}
