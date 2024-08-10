package com.project.backend.service;

import jakarta.mail.Message;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private final JavaMailSender mailSender;
    private final String adminEmail = "phuctphps26443@fpt.edu.vn";

    public ContactService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendContactForm( String email, String subject, String messageContent) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            message.setFrom(new InternetAddress(email)); 
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(adminEmail)); 
            message.setSubject(subject);
            message.setText( "Message: " + messageContent);
            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
