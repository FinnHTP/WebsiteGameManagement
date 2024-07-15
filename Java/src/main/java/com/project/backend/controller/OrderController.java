package com.project.backend.controller;


import com.project.backend.dto.OrderDto;
import com.project.backend.entity.Order;
import com.project.backend.repository.AccountRepository;
import com.project.backend.repository.GameRepository;
import com.project.backend.repository.OrderDetailRepository;
import com.project.backend.service.OrderService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private OrderDetailRepository orderDetail;
    
    
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody CreateOrderRequest request) {
        try {
            Order createdOrder = service.createOrder(request.getAccountId(), request.gameId, request.price);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    

    @GetMapping("/data{year}")
    public Map<String, Double> getDataByYear(@PathVariable("year") int year) {
        List<Object[]> stats = orderDetail.getMonthlyStatistics(year);
        Map<String, Double> data = new HashMap<>();
        for (Object[] stat : stats) {
            Integer month = (Integer) stat[0];
            Double total = (Double) stat[1];
            data.put(getMonthName(month), total);
        }
        return data;
    }
//    @GetMapping("/data2")
//    public Map<String, Double> getData2() {
//        List<Object[]> stats = service.getMonthlyStatistics2024();
//        Map<String, Double> data = new HashMap<>();
//        for (Object[] stat : stats) {
//            Integer month = (Integer) stat[0];
//            Double total = (Double) stat[1];
//            data.put(getMonthName(month), total);
//        }
//        return data;
//    }
    
    
    
    private String getMonthName(int month) {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return months[month - 1];
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
