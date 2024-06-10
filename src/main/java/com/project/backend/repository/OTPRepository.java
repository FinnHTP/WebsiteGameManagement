package com.project.backend.repository;

import com.project.backend.entity.Account;
import com.project.backend.entity.OTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface OTPRepository extends JpaRepository<OTP, Long> {
	OTP findByAccount (Account user);

	@Transactional
	void deleteByAccount (Account user);
}