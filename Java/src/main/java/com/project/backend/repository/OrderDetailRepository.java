package com.project.backend.repository;

import com.project.backend.entity.OrderDetail;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

	
	 @Query(value = "SELECT MONTH(o.date) AS month, SUM(od.price) AS total_price " +
             "FROM orders o " +
             "JOIN orderdetails od ON o.id = od.order_id " +
             "WHERE YEAR(o.date) = :year " +
             "GROUP BY MONTH(o.date) " +
             "ORDER BY MONTH(o.date)", nativeQuery = true)
List<Object[]> getMonthlyStatistics(@Param("year") int year);


//@Query(value = "SELECT MONTH(o.date) AS month, SUM(od.price) AS total_price " +
//        "FROM orders o " +
//        "JOIN orderdetails od ON o.id = od.order_id " +
//        "WHERE YEAR(o.date) = 2024 " +
//        "GROUP BY MONTH(o.date) " +
//        "ORDER BY MONTH(o.date)", nativeQuery = true)
//List<Object[]> getMonthlyStatistics2024();
}
