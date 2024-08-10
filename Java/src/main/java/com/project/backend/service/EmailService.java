package com.project.backend.service;

import jakarta.mail.Message;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	private final JavaMailSender mailSender;
	private final String adminEmail = "phuctphps26443@fpt.edu.vn";
	public EmailService(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void sendOTP (String email, String otp) {
		MimeMessage message = mailSender.createMimeMessage();
		try
		{

			message.setFrom(adminEmail);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.setSubject("FORGOT PASSWORD OTP");
			message.setText("Your OTP code: " + otp);
			mailSender.send(message);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
