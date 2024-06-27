package com.project.backend.dto;

import com.project.backend.entity.Game;
import com.project.backend.entity.KeyCode;
import com.project.backend.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDto {
    private Long id;
    private KeyCode keycode;
    private Double price;
    private Game game;
    private Order order;
}
