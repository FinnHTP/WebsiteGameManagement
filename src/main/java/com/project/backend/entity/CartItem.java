package com.project.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CartItem {
    private Integer id;
    private String name;
    private Double price;
    private Integer bullet;
    private String image;
    private int qty = 1;
}
