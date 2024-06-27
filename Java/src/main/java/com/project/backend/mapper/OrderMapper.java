package com.project.backend.mapper;

import com.project.backend.dto.KeyCodeDto;
import com.project.backend.dto.OrderDto;
import com.project.backend.entity.KeyCode;
import com.project.backend.entity.Order;

public class OrderMapper {
    public static OrderDto mapToOrderDto(Order order){
        return new OrderDto(
                order.getId(),
                order.getDate(),
                order.getAccount()
        );
    }

    public static Order mapToOrder(OrderDto orderDto){
       Order order = new Order();
       order.setId(orderDto.getId());
       order.setDate(orderDto.getDate());
       order.setAccount(orderDto.getAccount());
       return order;
    }
}
