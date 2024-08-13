package com.project.backend.dto;

import com.project.backend.entity.Coupon;
import com.project.backend.entity.GameType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameDto {
    private Long id;
    private String name;
    private String description;
    private Double priceGame;
    private Boolean status;
    private LocalDate releaseDate;
    private String version;
    private String image;
    private GameType gameType;
    private Coupon coupon;
}
