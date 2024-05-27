package com.project.backend.service.impl;

import com.project.backend.dto.GameTypeDto;
import com.project.backend.entity.GameType;
import com.project.backend.exception.ResourceNotFoundException;
import com.project.backend.mapper.GameMapper;
import com.project.backend.mapper.GameTypeMapper;
import com.project.backend.repository.GameTypeRepository;
import com.project.backend.service.GameTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GameTypeServiceImpl implements GameTypeService {
    private GameTypeRepository gameTypeRepository;

    @Override
    public GameTypeDto createGameType(GameTypeDto gameTypeDto) {
        GameType gameType = GameTypeMapper.mapToGameType(gameTypeDto);
        GameType savedGameType = gameTypeRepository.save(gameType);
        return GameTypeMapper.mapToGameTypeDto(savedGameType);
    }

    @Override
    public GameTypeDto getGameTypeById(Long gameTypeId) {
        GameType gameType = gameTypeRepository.findById(gameTypeId).orElseThrow(() -> new ResourceNotFoundException("GameType is not exist with given id :" + gameTypeId));
        return GameTypeMapper.mapToGameTypeDto(gameType);
    }

    @Override
    public List<GameTypeDto> getAllGameType() {
        List<GameType> gametypes = gameTypeRepository.findAll();
        return gametypes.stream().map((gameType) -> GameTypeMapper.mapToGameTypeDto(gameType)).collect(Collectors.toList());
    }

    @Override
    public GameTypeDto updatedGameType(Long gameTypeId, GameTypeDto gameTypeDto) {
        GameType gameType = gameTypeRepository.findById(gameTypeId).orElseThrow(() -> new ResourceNotFoundException("GameType is not exist with given id " + gameTypeId));
        gameType.setId(gameTypeDto.getId());
        gameType.setName(gameTypeDto.getName());
        return GameTypeMapper.mapToGameTypeDto(gameType);
    }

    @Override
    public void deleteGameType(Long gameTypeId) {
        GameType gameType = gameTypeRepository.findById(gameTypeId).orElseThrow(() -> new ResourceNotFoundException("GameType is not exist with given id " + gameTypeId));
        gameTypeRepository.deleteById(gameTypeId);
    }

}
