package com.project.backend.service;

import com.project.backend.dto.GameDto;
import com.project.backend.entity.Game;

import java.net.URISyntaxException;
import java.util.List;

public interface GameService {
  GameDto createGame(GameDto gameDto);
  GameDto getGameById(Long gameId);
  List<GameDto> getAllGame();
  List<GameDto> get8Game();
  GameDto updateGame(Long gameId, GameDto updatedGameDto);
  void deleteGame(Long gameId);
  //List<Game>getGamesByOrderId(Long orderId);
  GameDto getOrderByGameId(Long gameId);
  String getImageData(Long gameId);
}
