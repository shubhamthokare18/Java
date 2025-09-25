package com.example.readmail.controller;

import jakarta.mail.*;
import jakarta.mail.Flags.Flag;
import jakarta.mail.search.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Properties;

@RestController
public class ReadMailController {

    @Value("${spring.mail.imap.host}")
    private String host;

    @Value("${spring.mail.imap.port}")
    private int port;

    @Value("${spring.mail.imap.user}")
    private String user;

    @Value("${spring.mail.imap.password}")
    private String password;

    @Value("${spring.mail.imap.protocol}")
    private String protocol;

    @GetMapping("/read")
    public String readMail(
            @RequestParam(required = false) String subject,
            @RequestParam(required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
            @RequestParam(required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate,
            @RequestParam(defaultValue = "false") boolean unseenOnly
    ) throws Exception {

        // Mail properties
        Properties properties = new Properties();
        properties.put("mail.store.protocol", protocol);
        properties.put("mail.imap.host", host);
        properties.put("mail.imap.port", port);
        properties.put("mail.imap.ssl.enable", "true");

        // Session and connection
        Session session = Session.getInstance(properties);
        Store store = session.getStore(protocol);
        store.connect(host, user, password);

        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        // Build search terms
        SearchTerm searchTerm = null;

        if (subject != null) {
            searchTerm = new SubjectTerm(subject);
        }

        if (fromDate != null) {
            ReceivedDateTerm fromTerm = new ReceivedDateTerm(ComparisonTerm.GE, fromDate);
            searchTerm = (searchTerm == null) ? fromTerm : new AndTerm(searchTerm, fromTerm);
        }

        if (toDate != null) {
            ReceivedDateTerm toTerm = new ReceivedDateTerm(ComparisonTerm.LE, toDate);
            searchTerm = (searchTerm == null) ? toTerm : new AndTerm(searchTerm, toTerm);
        }

        if (unseenOnly) {
            FlagTerm unseen = new FlagTerm(new Flags(Flag.SEEN), false);
            searchTerm = (searchTerm == null) ? unseen : new AndTerm(searchTerm, unseen);
        }

        // Fetch messages
        Message[] messages;
        if (searchTerm != null) {
            messages = inbox.search(searchTerm);
        } else {
            messages = inbox.getMessages();
        }

        // Build response
        StringBuilder sb = new StringBuilder("Emails:\n");
        for (Message msg : messages) {
            boolean isSeen = msg.isSet(Flag.SEEN);
            sb.append("From: ").append(msg.getFrom()[0].toString())
                    .append(" | Subject: ").append(msg.getSubject())
                    .append(" | Date: ").append(msg.getReceivedDate())
                    .append(" | Seen: ").append(isSeen ? "YES" : "NO")
                    .append("\n");
        }

        inbox.close(false);
        store.close();

        return sb.toString();
    }
}