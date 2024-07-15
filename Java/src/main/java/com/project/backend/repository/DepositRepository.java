package com.project.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.backend.entity.Deposit;

public interface DepositRepository extends JpaRepository<Deposit, Long>{
    @Query("select o from Deposit o where o.account.id = ?1")
    List<Deposit> findListById(Long accountId);
}
