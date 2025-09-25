package com.example.mail.controller;

import com.example.mail.service.MailService;
import jakarta.mail.MessagingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    private final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/sendMail")
    public String sendMail(@RequestParam String to) throws MessagingException {
        mailService.sendMail(to);
        return "📧 Mail request submitted to " + to;
    }
}
