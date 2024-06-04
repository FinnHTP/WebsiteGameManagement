package com.project.backend.repository;

import com.project.backend.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUserName(String username);
}
