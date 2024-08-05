package com.project.backend.service;

import java.util.List;
import java.util.Map;

import com.project.backend.dto.GameDto;

public interface GameService {
  GameDto createGame(GameDto gameDto);
  GameDto getGameById(Long gameId);
  List<GameDto> getAllGame();

  List<GameDto> get8Game();

  GameDto updateGame(Long gameId, GameDto updatedGameDto);
  void deleteGame(Long gameId);
List<Object[]> getTotalRevenueByGame();
Map<String, Double> getMonthlyStatistics();

}
