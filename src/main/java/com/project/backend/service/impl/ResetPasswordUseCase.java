package com.project.backend.service.impl;

import com.project.backend.entity.Account;
import com.project.backend.entity.OTP;
import com.project.backend.repository.AccountRepository;
import com.project.backend.repository.OTPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ResetPasswordUseCase {
	@Autowired
	private AccountRepository userRepository;

	@Autowired
	private OTPRepository otpRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;


	private static final long OTP_EXPIRATION_MINUTES = 1;
	private static final long OTP_EXPIRATION_HOURS = 1;

	public boolean isExpired (OTP otp) {
		return otp.getGeneratedTime().plusHours(OTP_EXPIRATION_HOURS).isBefore(LocalDateTime.now());
	}

	public void resetPassword (String email, String otp, String newPassword) {
		Account user = userRepository.findByEmail(email);
		if (user == null)
		{
			throw new IllegalArgumentException("Invalid email");
		}
		OTP otpToken = otpRepository.findByAccount(user);
		if (otpToken == null)
		{
			throw new IllegalArgumentException("No OTP for this account");
		}
		if (isExpired(otpToken))
		{
			otpRepository.delete(otpToken);
			throw new IllegalArgumentException("OTP has expired");
		}
		if (!otp.equals(otpToken.getOtp()))
		{
			throw new IllegalArgumentException("Invalid OTP");
		}
//		change password
		user.setPassword(newPassword);
		System.out.println(user.getPassword());
//		user.setEmployee(employee);

		userRepository.save(user);
//		clean used otp
		otpRepository.delete(otpToken);
	}
}
