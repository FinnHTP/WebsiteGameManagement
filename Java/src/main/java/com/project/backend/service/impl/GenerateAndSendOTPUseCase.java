package com.project.backend.service.impl;

import com.project.backend.entity.Account;
import com.project.backend.entity.OTP;
import com.project.backend.repository.AccountRepository;
import com.project.backend.repository.OTPRepository;
import com.project.backend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GenerateAndSendOTPUseCase {
	@Autowired
	private AccountRepository userRepository;

	@Autowired
	private OTPRepository otpRepository;

	@Autowired
	private EmailService emailService;

	private String generateOTP () {
		return String.valueOf((int) (Math.random() * 900000) + 100000);
	}

	public void generateAndSendOTP (String email) {
		Account user = userRepository.findByEmail(email);
		if (user == null)
		{
			throw new IllegalArgumentException("Invalid email");
		}
		System.out.println(user.getEmail());
		//remove existed otp in account
		otpRepository.deleteByAccount(user);

		//generate new otp
		String otp = generateOTP();
		OTP otpToken = new OTP();
		otpToken.setOtp(otp);
		otpToken.setGeneratedTime(LocalDateTime.now());
		otpToken.setAccount(user);
		otpRepository.save(otpToken);

		emailService.sendOTP(email, otp);
	}
}
