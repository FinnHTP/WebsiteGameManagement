package com.project.backend.mapper;

import com.project.backend.dto.GameImageDto;
import com.project.backend.entity.GameImage;

public class GameImageMapper {
    public static GameImageDto mapToGameImageDto(GameImage gameImage){
        return new GameImageDto(
                gameImage.getId(),
                gameImage.getNameImage(),
                gameImage.getGame(),
                gameImage.getDate()
        );
    }
    public static GameImage mapToGameImage(GameImageDto dto){
        GameImage image = new GameImage();
        image.setId(dto.getId());
        image.setNameImage(dto.getNameImage());
        image.setGame(dto.getGame());
        image.setDate(dto.getDate());
        return image;
    }
}
