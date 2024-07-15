package com.project.backend.service;

import java.util.List;

import com.project.backend.dto.OrderDto;
import com.project.backend.entity.Order;

public interface OrderService {
    Order createOrder(Long accountId, Long gameId, Double priced);
    OrderDto getOrderById(Long orderId);
    List<OrderDto> getAllOrders();
    OrderDto UpdateOrder(Long orderId ,OrderDto updatedOrderDto);
    void deleteOrder(Long orderId);
    List<OrderDto> GetAllOrderById(Long accountId);
}
