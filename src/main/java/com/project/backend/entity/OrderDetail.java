package com.project.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orderdetails")
public class OrderDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "price")
    private Double price;
    @Column(name = "quantity")
    private Long quantity;
    @ManyToOne @JoinColumn(name = "gameId")
    private Game game;
    @ManyToOne @JoinColumn(name = "orderId")
    private Order order;
    @ManyToOne @JoinColumn(name = "accountId")
    private Account account;


}
