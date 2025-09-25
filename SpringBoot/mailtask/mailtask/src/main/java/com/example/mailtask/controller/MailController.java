package com.example.mailtask.controller;

import com.example.mailtask.service.MailReceiverService;
import com.example.mailtask.service.MailSenderService;
import jakarta.mail.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mail")
public class MailController {

    private final MailSenderService mailSenderService;
    private final MailReceiverService mailReceiverService;

    @PostMapping("/send")
    public String sendMail(@RequestParam String to, @RequestParam String subject, @RequestParam String text) throws Exception {
        mailSenderService.sendSimpleMail(to, subject, text);
        return "Mail Sent!";
    }

    @GetMapping("/unseen")
    public List<String> getUnseenMails() throws Exception {
        List<Message> messages = mailReceiverService.fetchUnseenMails();
        return messages.stream().map(m -> {
            try {
                return m.getSubject();
            } catch (Exception e) {
                return "Error";
            }
        }).toList();
    }
}
