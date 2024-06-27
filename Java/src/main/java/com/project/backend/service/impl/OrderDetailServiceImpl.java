package com.project.backend.service.impl;

import com.project.backend.dto.OrderDetailDto;
import com.project.backend.dto.OrderDto;
import com.project.backend.entity.Order;
import com.project.backend.entity.OrderDetail;
import com.project.backend.exception.ResourceNotFoundException;
import com.project.backend.mapper.OrderDetailMapper;
import com.project.backend.mapper.OrderMapper;
import com.project.backend.repository.OrderDetailRepository;
import com.project.backend.service.OrderDetailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService {
    private OrderDetailRepository repository;

    @Override
    public OrderDetailDto createorderdetail(OrderDetailDto Dto) {
        OrderDetail order = OrderDetailMapper.mapToOrder(Dto);
        OrderDetail savedOrder = repository.save(order);
        return OrderDetailMapper.mapToOrderDto(savedOrder);
    }


    @Override
    public OrderDetailDto getorderdetailById(Long orderId) {
        OrderDetail order = repository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order is not exist with given id " + orderId));
        return OrderDetailMapper.mapToOrderDto(order);
    }

    @Override
    public List<OrderDetailDto> getAllorderdetail() {
        List<OrderDetail> orders = repository.findAll();
        return orders.stream().map((order) -> OrderDetailMapper.mapToOrderDto(order)).collect(Collectors.toList());
    }

    @Override
    public OrderDetailDto UpdateOrderDetail(Long orderId, OrderDetailDto updatedOrderDetailDto) {
        OrderDetail order = repository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order is not exist with given id :" + orderId));
//        order.setDate(updatedOrderDto.getDate());
        order.setPrice(updatedOrderDetailDto.getPrice());
        OrderDetail updatedOrderObj = repository.save(order);
        return OrderDetailMapper.mapToOrderDto(updatedOrderObj);
    }

    @Override
    public void deleteOrderDetail(Long orderId) {
        OrderDetail order = repository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order is not exist with given id + " + orderId));
        repository.delete(order);
    }
}
