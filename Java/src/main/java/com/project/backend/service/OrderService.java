package com.project.backend.service;

import com.project.backend.dto.KeyCodeDto;
import com.project.backend.dto.OrderDto;
import com.project.backend.entity.Account;
import com.project.backend.entity.Game;
import com.project.backend.entity.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Long accountId, Long gameId, Double priced);
    OrderDto getOrderById(Long orderId);
    List<OrderDto> getAllOrders();
    OrderDto UpdateOrder(Long orderId ,OrderDto updatedOrderDto);
    void deleteOrder(Long orderId);
}
