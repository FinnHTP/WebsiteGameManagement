package com.project.backend.service.impl;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.backend.dto.OrderDto;
import com.project.backend.entity.KeyCode;
import com.project.backend.entity.Order;
import com.project.backend.entity.OrderDetail;
import com.project.backend.exception.ResourceNotFoundException;
import com.project.backend.mapper.OrderMapper;
import com.project.backend.repository.AccountRepository;
import com.project.backend.repository.GameRepository;
import com.project.backend.repository.KeycodeRepository;
import com.project.backend.repository.OrderDetailRepository;
import com.project.backend.repository.OrderRepository;
import com.project.backend.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private KeycodeRepository keyCodeRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public Order createOrder(Long accountId, Long gameId, Double price) {
        // Tạo một đối tượng Order mới
        Order order = new Order();

        // Thiết lập tài khoản cho đơn hàng từ accountId
        order.setAccount(accountRepository.findById(accountId).orElse(null));

        // Tạo một OrderDetail mới
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setPrice(price); // Thiết lập giá
        orderDetail.setOrder(order);

        // Thiết lập Game cho OrderDetail từ gameId
        orderDetail.setGame(gameRepository.findById(gameId).orElse(null));

        // Lưu OrderDetail vào cơ sở dữ liệu


        // Tạo một đối tượng KeyCode mới và tạo mã ngẫu nhiên cho nó
        KeyCode keyCode = new KeyCode();
        keyCode.generateKeyCode(); // Phương thức generateKeyCode() tạo mã ngẫu nhiên

        // Thiết lập thông tin cho KeyCode
        keyCode.setGame(orderDetail.getGame());
        keyCode.setCreateDate(LocalDate.now());
        keyCode.setIsActive(true);

        // Liên kết KeyCode với OrderDetail
        keyCode.setOrderDetail(orderDetail);
        orderDetail.setKeycode(keyCode);
        // Lưu KeyCode vào cơ sở dữ liệu
        keyCodeRepository.save(keyCode);
        orderDetailRepository.save(orderDetail);
        // Thiết lập OrderDetail cho Order
        order.setOrderDetails(Collections.singletonList(orderDetail));

        // Lưu đơn hàng và trả về kết quả
        return orderRepository.save(order);
    }

    @Override
    public OrderDto getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + orderId));
        return OrderMapper.mapToOrderDto(order);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(OrderMapper::mapToOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto UpdateOrder(Long orderId, OrderDto updatedOrderDto) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + orderId));

        // Cập nhật thông tin order
        order.setAccount(updatedOrderDto.getAccount());

        // Lưu lại và trả về order đã cập nhật
        Order updatedOrder = orderRepository.save(order);
        return OrderMapper.mapToOrderDto(updatedOrder);
    }

    @Override
    public void deleteOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + orderId));
        orderRepository.delete(order);
    }

    @Override
    public List<OrderDto> GetAllOrderById(Long accountId) {
        // TODO Auto-generated method stub
        List<Order> orders = orderRepository.findListById(accountId);
        return orders.stream().map((order) -> OrderMapper.mapToOrderDto(order)).collect(Collectors.toList());
    }
}
