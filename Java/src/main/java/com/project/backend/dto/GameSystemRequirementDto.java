package com.project.backend.dto;

import com.project.backend.entity.Game;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameSystemRequirementDto {
    private Long id;
    private Game game;
    private String os;
    private String memory;
    private String card;
    private String proccessor;
    private String storage;



}
