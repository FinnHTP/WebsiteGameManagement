package com.project.backend.service;

import com.project.backend.dto.GameTypeDto;
import com.project.backend.entity.GameType;

import java.util.List;

public interface GameTypeService {
    GameTypeDto createGameType(GameTypeDto gameTypeDto);
    GameTypeDto getGameTypeById(Long gameTypeId);
    List<GameTypeDto> getAllGameType();
    GameTypeDto updatedGameType(Long gameTypeId , GameTypeDto gameTypeDto);
    void deleteGameType(Long gameTypeId);
}
