package com.project.backend.controller;

import com.project.backend.dto.OrderDetailDto;
import com.project.backend.dto.OrderDto;
import com.project.backend.service.OrderDetailService;
import com.project.backend.service.OrderService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/ordersdetail")
@SecurityRequirement(name = "bearerAuth")
public class OrderDetailController {
    private OrderDetailService service;

    @PostMapping
    public ResponseEntity<OrderDetailDto> createorder(@RequestBody OrderDetailDto orderDto){
        OrderDetailDto savedOrder = service.createorderdetail(orderDto);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<OrderDetailDto> getkeycodeById(@PathVariable("id") Long orderId){
        OrderDetailDto Dto = service.getorderdetailById(orderId);
        return ResponseEntity.ok(Dto);
    }
    @GetMapping
    public ResponseEntity<List<OrderDetailDto>> getAllOrder(){
        List<OrderDetailDto> orderDtos = service.getAllorderdetail();
        return ResponseEntity.ok(orderDtos);
    }
    @PutMapping("{id}")
    public ResponseEntity<OrderDetailDto> updateOrder(@PathVariable("id") Long orderId, @RequestBody OrderDetailDto dto){
        OrderDetailDto orderDto = service.UpdateOrderDetail(orderId , dto);
        return ResponseEntity.ok(orderDto);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") Long orderId){
        service.deleteOrderDetail(orderId);
        return ResponseEntity.ok("Order deleted Successfully");
    }
}

