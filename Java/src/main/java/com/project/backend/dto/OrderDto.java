package com.project.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.backend.entity.Account;
import com.project.backend.entity.OrderDetail;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private Date date = new Date();
    private Account account;
}
