package com.project.backend.dto;

import com.project.backend.entity.Account;
import com.project.backend.entity.Game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteDto {
    private Long id;
    private Boolean isActive;
    private Game game;
    private Account account;
}
