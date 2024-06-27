package com.project.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.backend.entity.Deposit;

public interface DepositRepository extends JpaRepository<Deposit, Long>{
}
