//package com.example.tesseract.controller;
//
//import net.sourceforge.tess4j.Tesseract;
//import net.sourceforge.tess4j.TesseractException;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.rendering.PDFRenderer;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//import java.util.UUID;
//
//import static jdk.internal.vm.vector.VectorSupport.extract;
//
//@RestController
//public class OcrController {
//    @GetMapping("/readFile")
//    public ResponseEntity<String> readFile(@RequestParam MultipartFile multipartFile) throws IOException, TesseractException{
//        Tesseract tesseract=new Tesseract();
//        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
//        tesseract.setLanguage("eng");
//        if (multipartFile.getContentType()!=null){
//            if (multipartFile.getContentType().startsWith("image/")) {
//                System.out.println(multipartFile.getContentType());
//                Path path = Paths.get("ocr-" + UUID.randomUUID().toString().substring(0, 3) + extract(multipartFile.getOriginalFilename()));
//                Files.copy(multipartFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
//                BufferedImage bufferedImage = ImageIO.read(path.toFile());
//                String s = tesseract.doOCR(bufferedImage);
//                System.out.println(s);
//            }
//                if (multipartFile.getContentType().equals("application/pdf")){
//                    System.out.println(multipartFile.getContentType());
//                    Path path=Paths.get("pdf-"+UUID.randomUUID().toString().substring(0, 3) + extract(multipartFile.getOriginalFilename()));
//                    byte[] bytes=multipartFile.getBytes();
//                    Files.copy(new ByteArrayInputStream(bytes), path, StandardCopyOption.REPLACE_EXISTING);
//                    PDDocument pdDocument=PDDocument.load(path.toFile());
//                    PDFRenderer pdfRenderer=new PDFRenderer(pdDocument);
//                    for (int page=0;page<pdDocument.getNumberOfPages();page++){
//                        BufferedImage bufferedImage=pdfRenderer.renderImageWithDPI(page
//                                , 300);
//                        String s=tesseract.doOCR(bufferedImage);
//                        System.out.println(s);
//                }
//            }
//        }
//        return ResponseEntity.ok("OK");
//    }
//    public String extract(String filename) {
//        return filename.substring(filename.lastIndexOf('.'));
//    }
//}