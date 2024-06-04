package com.project.backend.dto;

import com.project.backend.entity.Game;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameImageDto {
    private Long id;
    private String nameImage;
    private Game game;
    private LocalDate date;
}
