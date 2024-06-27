package com.project.backend.auth;

import com.project.backend.repository.AccountRepository;
import com.project.backend.service.impl.GenerateAndSendOTPUseCase;
import com.project.backend.service.impl.ResetPasswordUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin ("*")
@RestController
@RequestMapping ("/api/password")
public class ResetPasswordController {
	@Autowired
	private GenerateAndSendOTPUseCase generateAndSendOTPUseCase;

	@Autowired
	private ResetPasswordUseCase resetPasswordUseCase;

	@Autowired
	private AccountRepository userRepository;

	@PostMapping ("/forgot")
	public ResponseEntity<String> forgotPassword (@RequestParam String email) {
		try
		{
			generateAndSendOTPUseCase.generateAndSendOTP(email);
			return ResponseEntity.ok("OTP has sent to your email");
		} catch (IllegalArgumentException exception)
		{
			return ResponseEntity.badRequest().body(exception.getMessage());
		}
	}

	@PostMapping ("/reset")
	public ResponseEntity<String> resetPassword (@RequestParam String email, @RequestParam String otp,
	                                             @RequestParam String newPassword) {
		try
		{
			resetPasswordUseCase.resetPassword(email, otp, newPassword);
			return ResponseEntity.ok("Password has been reset successfully");
		} catch (IllegalArgumentException e)
		{
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
