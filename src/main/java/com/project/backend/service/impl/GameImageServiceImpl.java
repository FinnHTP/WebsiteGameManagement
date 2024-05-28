package com.project.backend.service.impl;

import com.project.backend.dto.GameImageDto;
import com.project.backend.entity.GameImage;
import com.project.backend.exception.ResourceNotFoundException;
import com.project.backend.mapper.GameImageMapper;
import com.project.backend.repository.GameImageRepository;
import com.project.backend.service.GameImageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GameImageServiceImpl implements GameImageService {
    private GameImageRepository imageRepository;


    @Override
    public GameImageDto createGameimage(GameImageDto imageDto) {
        GameImage image = GameImageMapper.mapToGameImage(imageDto);
        GameImage savedGameImage = imageRepository.save(image);
        return GameImageMapper.mapToGameImageDto(savedGameImage);
    }

    @Override
    public GameImageDto getGameImageById(Long GameImageId) {
        GameImage gameImage = imageRepository.findById(GameImageId).orElseThrow(() -> new ResourceNotFoundException("Game is not exist with given id " + GameImageId));
        return GameImageMapper.mapToGameImageDto(gameImage);
    }

    @Override
    public List<GameImageDto> getAllGameImage() {
        List<GameImage> gameImageList = imageRepository.findAll();
        return gameImageList.stream().map((gameImage) -> GameImageMapper.mapToGameImageDto(gameImage)).collect(Collectors.toList());
    }

    @Override
    public GameImageDto updateGameImage(Long gameImageId, GameImageDto updatedGameImageDto) {
        GameImage gameImage = imageRepository.findById(gameImageId).orElseThrow(() -> new ResourceNotFoundException("Game is not exist with given id :" + gameImageId));
        gameImage.setId(updatedGameImageDto.getId());
        gameImage.setNameImage(updatedGameImageDto.getNameImage());
        gameImage.setGame(updatedGameImageDto.getGame());
        gameImage.setDate(updatedGameImageDto.getDate());
        GameImage updatedGameImageObj = imageRepository.save(gameImage);
        return GameImageMapper.mapToGameImageDto(updatedGameImageObj);
    }

    @Override
    public void deleteGameImage(Long GameImageId) {
        GameImage gameImage = imageRepository.findById(GameImageId).orElseThrow(() -> new ResourceNotFoundException("Game is not exist with given id + " + GameImageId));
        imageRepository.delete(gameImage);
    }
}
