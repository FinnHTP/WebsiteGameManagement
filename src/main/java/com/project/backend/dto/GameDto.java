package com.project.backend.dto;

import com.project.backend.entity.GameType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Date releaseDate;
    private String version;
    private GameType gameType;
}
