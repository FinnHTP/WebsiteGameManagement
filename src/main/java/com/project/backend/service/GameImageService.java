package com.project.backend.service;

import com.project.backend.dto.GameImageDto;
import java.util.List;

public interface GameImageService {
    GameImageDto createGameimage(GameImageDto imageDto);
    GameImageDto getGameImageById(Long GameImageId);
    List<GameImageDto> getAllGameImage();
    GameImageDto updateGameImage(Long gameImageId,GameImageDto updatedGameImageDto);
    void deleteGameImage(Long GameImageId);
}
