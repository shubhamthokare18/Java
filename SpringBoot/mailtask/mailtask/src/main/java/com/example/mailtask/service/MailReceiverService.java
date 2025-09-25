package com.example.mailtask.service;

import com.example.mailtask.config.MailProperties;
import jakarta.mail.*;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.search.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;

@Service
@RequiredArgsConstructor
public class MailReceiverService {

    private final MailProperties mailProperties;

    public List<Message> fetchUnseenMails() throws Exception {
        Properties props = new Properties();
        props.put("mail.store.protocol", mailProperties.getImap().getProtocol());
        Session session = Session.getDefaultInstance(props);

        Store store = session.getStore(mailProperties.getImap().getProtocol());
        store.connect(mailProperties.getImap().getHost(), "shubhamthokare.eidiko@gmail.com", System.getenv("MAIL_PASS"));

        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        // Fetch unseen mails
        FlagTerm unseenFlagTerm = new FlagTerm(new Flags(Flags.Flag.SEEN), false);

        // Example filter: unseen AND subject contains "Invoice"
        SubjectTerm subjectTerm = new SubjectTerm("Invoice");
        SearchTerm searchTerm = new AndTerm(unseenFlagTerm, subjectTerm);

        Message[] messages = inbox.search(new OrTerm(unseenFlagTerm, subjectTerm));

        return Arrays.asList(messages);
    }

    public void saveAttachments(Message message, String outputDir) throws Exception {
        if (message.isMimeType("multipart/*")) {
            Multipart multipart = (Multipart) message.getContent();

            for (int i = 0; i < multipart.getCount(); i++) {
                BodyPart bodyPart = multipart.getBodyPart(i);

                if (Part.ATTACHMENT.equalsIgnoreCase(bodyPart.getDisposition())) {
                    MimeBodyPart mimeBodyPart = (MimeBodyPart) bodyPart;
                    File file = new File(outputDir + File.separator + mimeBodyPart.getFileName());
                    mimeBodyPart.saveFile(file);
                }
            }
        }
    }
}
