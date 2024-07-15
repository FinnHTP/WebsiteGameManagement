package com.project.backend.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.backend.dto.OrderDto;
import com.project.backend.entity.Order;
import com.project.backend.repository.AccountRepository;
import com.project.backend.repository.GameRepository;
import com.project.backend.service.OrderService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/orders")
@SecurityRequirement(name = "bearerAuth")
public class OrderController {
    @Autowired
    private OrderService service;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private GameRepository gameRepository;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody CreateOrderRequest request) {
        try {
            Order createdOrder = service.createOrder(request.getAccountId(), request.gameId, request.price);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @GetMapping("{id}")
    public ResponseEntity<OrderDto> getkeycodeById(@PathVariable("id") Long orderId){
        OrderDto Dto = service.getOrderById(orderId);
        return ResponseEntity.ok(Dto);
    }
    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrder(){
        List<OrderDto> orderDtos = service.getAllOrders();
        return ResponseEntity.ok(orderDtos);
    }
    @GetMapping("/list/{id}")
    public ResponseEntity<List<OrderDto>> getListOrderById(@PathVariable("id") Long accountId){
        List<OrderDto> orders = service.GetAllOrderById(accountId);
        return ResponseEntity.ok(orders);
    }
    @PutMapping("{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable("id") Long orderId, @RequestBody OrderDto dto){
        OrderDto orderDto = service.UpdateOrder(orderId , dto);
        return ResponseEntity.ok(orderDto);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") Long orderId){
        service.deleteOrder(orderId);
        return ResponseEntity.ok("Order deleted Successfully");
    }
    public static class CreateOrderRequest {
        private Long accountId;
        private Long gameId;
        private Double price;

        public Long getAccountId() {
            return accountId;
        }

        public void setAccountId(Long accountId) {
            this.accountId = accountId;
        }

        public Long getGameId() {
            return gameId;
        }

        public void setGameId(Long gameId) {
            this.gameId = gameId;
        }
        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }
    }

}
