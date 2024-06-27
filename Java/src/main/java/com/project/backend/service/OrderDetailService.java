package com.project.backend.service;

import com.project.backend.dto.OrderDetailDto;
import com.project.backend.dto.OrderDto;

import java.util.List;

public interface OrderDetailService {
    OrderDetailDto createorderdetail(OrderDetailDto Dto);
    OrderDetailDto getorderdetailById(Long orderDetailId);
    List<OrderDetailDto> getAllorderdetail();
    OrderDetailDto UpdateOrderDetail(Long orderDetailId ,OrderDetailDto updatedOrderDetailDto);
    void deleteOrderDetail(Long orderDetailId);


}