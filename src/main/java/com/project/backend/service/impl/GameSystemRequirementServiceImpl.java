package com.project.backend.service.impl;


import com.project.backend.dto.GameDto;
import com.project.backend.dto.GameSystemRequirementDto;
import com.project.backend.entity.Game;
import com.project.backend.entity.GameSystemRequirement;
import com.project.backend.exception.ResourceNotFoundException;
import com.project.backend.mapper.GameMapper;
import com.project.backend.mapper.GameSystemrequirementMapper;
import com.project.backend.repository.GameSystemRequirementRepository;
import com.project.backend.service.GameSystemRequirementService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GameSystemRequirementServiceImpl implements GameSystemRequirementService {
    private GameSystemRequirementRepository repository;

    @Override
    public GameSystemRequirementDto createGameSystemRequirement(GameSystemRequirementDto Dto) {
        GameSystemRequirement requirement = GameSystemrequirementMapper.mapToGameSystemRequirement(Dto);
        GameSystemRequirement savedGameSystemRequirement = repository.save(requirement);
        return GameSystemrequirementMapper.mapToGameSystemRequirementDto(savedGameSystemRequirement);
    }

    @Override
    public GameSystemRequirementDto getGameSystemRequirementById(Long GameSystemRequirementId) {
        GameSystemRequirement requirement =repository.findById(GameSystemRequirementId).orElseThrow(() -> new ResourceNotFoundException("Game is not exist with given id " + GameSystemRequirementId));
        return GameSystemrequirementMapper.mapToGameSystemRequirementDto(requirement);
    }

    @Override
    public List<GameSystemRequirementDto> getAllGameSystemRequirement() {
        List<GameSystemRequirement> gameSystemRequirements = repository.findAll();
        return gameSystemRequirements.stream().map((requirement) -> GameSystemrequirementMapper.mapToGameSystemRequirementDto(requirement)).collect(Collectors.toList());
    }

    @Override
    public GameSystemRequirementDto UpdateGameSystemRequirement(Long GameSystemRequirementId, GameSystemRequirementDto updatedGameSystemRequirement) {
        GameSystemRequirement requirement = repository.findById(GameSystemRequirementId).orElseThrow(() -> new ResourceNotFoundException("Game is not exist with given id :" + GameSystemRequirementId));
        requirement.setId(updatedGameSystemRequirement.getId());
        requirement.setGame(updatedGameSystemRequirement.getGame());
        requirement.setOs(updatedGameSystemRequirement.getOs());
        requirement.setMemory(updatedGameSystemRequirement.getMemory());
        requirement.setCard(updatedGameSystemRequirement.getCard());
        requirement.setProccessor(updatedGameSystemRequirement.getProccessor());
        requirement.setStorage(updatedGameSystemRequirement.getStorage());
        GameSystemRequirement  updateSystemRequirement= repository.save(requirement);
        return GameSystemrequirementMapper.mapToGameSystemRequirementDto(updateSystemRequirement);
    }

    @Override
    public void deleteGameSystemRequirement(Long GameSystemRequirementId) {
        GameSystemRequirement requirement = repository.findById(GameSystemRequirementId).orElseThrow(() -> new ResourceNotFoundException("Game is not exist with given id + " + GameSystemRequirementId));
        repository.delete(requirement);
    }


}
