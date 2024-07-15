package com.project.backend.service;

import com.project.backend.dto.KeyCodeDto;
import com.project.backend.dto.OrderDto;
import com.project.backend.entity.Account;
import com.project.backend.entity.Game;
import com.project.backend.entity.Order;
import com.project.backend.repository.OrderRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public interface OrderService {
	
	

	    
    Order createOrder(Long accountId, Long gameId, Double priced);
    OrderDto getOrderById(Long orderId);
    List<OrderDto> getAllOrders();
    OrderDto UpdateOrder(Long orderId ,OrderDto updatedOrderDto);
    void deleteOrder(Long orderId);
	List<Object[]> getMonthlyStatistics(int year);
//	List<Object[]> getMonthlyStatistics2024();
  
}
