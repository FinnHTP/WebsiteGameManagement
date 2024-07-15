package com.project.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.backend.entity.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("select o from Order o where o.account.id = ?1")
    List<Order> findListById(Long accountId);
}
