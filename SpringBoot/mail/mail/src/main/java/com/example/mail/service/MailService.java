package com.example.mail.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Async("threadPoolTaskExecutor")
    public void sendMail(String to) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

        helper.setTo(to);
        helper.setSubject("Test Mail from Spring Boot");
        helper.setText("<h1>Hello World!</h1><p>This is a test email.</p>", true);

        javaMailSender.send(mimeMessage);
        System.out.println("✅ Mail sent to " + to);

        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject("smm");
        simpleMailMessage.setText("hi smm");
        javaMailSender.send(simpleMailMessage);
        System.out.println("smm send to " + to);
    }
}
