package com.project.backend.service.impl;

import com.project.backend.dto.GameDto;
import com.project.backend.entity.Game;
import com.project.backend.exception.ResourceNotFoundException;
import com.project.backend.mapper.GameMapper;
import com.project.backend.repository.GameRepository;
import com.project.backend.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GameServiceImpl implements GameService {
    private GameRepository gameRepository;

    @Override
    public GameDto createGame(GameDto gameDto) {
        Game game = GameMapper.mapToGame(gameDto);
        Game savedGame = gameRepository.save(game);
        return GameMapper.mapToGameDto(savedGame);
    }

    @Override
    public GameDto getGameById(Long gameId) {
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new ResourceNotFoundException("Game is not exist with given id " + gameId));
        return GameMapper.mapToGameDto(game);
    }

    @Override
    public List<GameDto> getAllGame() {
        List<Game> games = gameRepository.findAll();
        return games.stream().map((game) -> GameMapper.mapToGameDto(game)).collect(Collectors.toList());
    }

    @Override
    public GameDto updateGame(Long gameId, GameDto updatedGameDto) {
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new ResourceNotFoundException("Game is not exist with given id :" + gameId));
        game.setName(updatedGameDto.getName());
        game.setDescription(updatedGameDto.getDescription());
        game.setPriceGame(updatedGameDto.getPriceGame());
        game.setStatus(updatedGameDto.getStatus());
        game.setReleaseDate(updatedGameDto.getReleaseDate());
        game.setVersion(updatedGameDto.getVersion());
        game.setGameType(updatedGameDto.getGameType());
        Game updatedGameObj = gameRepository.save(game);
        return GameMapper.mapToGameDto(updatedGameObj);
    }

    @Override
    public void deleteGame(Long gameId) {
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new ResourceNotFoundException("Game is not exist with given id + " + gameId));
        gameRepository.delete(game);
    }
}
