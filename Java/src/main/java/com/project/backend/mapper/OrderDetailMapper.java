package com.project.backend.mapper;

import com.project.backend.dto.OrderDetailDto;
import com.project.backend.dto.OrderDto;
import com.project.backend.entity.Order;
import com.project.backend.entity.OrderDetail;

public class OrderDetailMapper {
    public static OrderDetailDto mapToOrderDto(OrderDetail order){
        return new OrderDetailDto(
                order.getId(),
                order.getKeycode(),
                order.getPrice(),
                order.getGame(),
                order.getOrder()
        );
    }

    public static OrderDetail mapToOrder(OrderDetailDto orderDto){
        OrderDetail order = new OrderDetail();
        order.setId(orderDto.getId());
        order.setKeycode(orderDto.getKeycode());
        order.setPrice(orderDto.getPrice());
        order.setGame(orderDto.getGame());
        order.setOrder(orderDto.getOrder());
        return order;
    }
}
