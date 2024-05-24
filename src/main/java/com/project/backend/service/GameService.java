package com.project.backend.service;

import com.project.backend.dto.GameDto;
import com.project.backend.entity.Game;

import java.util.List;

public interface GameService {
  GameDto createGame(GameDto gameDto);
  GameDto getGameById(Long gameId);
  List<GameDto> getAllGame();
  GameDto updateGame(Long gameId,GameDto updatedGameDto);
  void deleteGame(Long gameId);

}
