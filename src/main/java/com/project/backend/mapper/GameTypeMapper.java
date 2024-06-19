package com.project.backend.mapper;

import com.project.backend.dto.GameTypeDto;
import com.project.backend.entity.GameType;

public class GameTypeMapper {
    public static GameTypeDto mapToGameTypeDto(GameType gameType){
        return new GameTypeDto(
                gameType.getId(),
                gameType.getName()
        );
    }
    public static GameType mapToGameType(GameTypeDto gameTypeDto){
        GameType gameType = new GameType();
        gameType.setId(gameTypeDto.getId());
        gameType.setName(gameTypeDto.getName());
        return gameType;
    }
}
