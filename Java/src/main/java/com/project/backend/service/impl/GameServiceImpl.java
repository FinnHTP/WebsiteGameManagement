package com.project.backend.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.project.backend.dto.GameDto;
import com.project.backend.entity.Game;
import com.project.backend.exception.ResourceNotFoundException;
import com.project.backend.mapper.GameMapper;
import com.project.backend.repository.GameRepository;
import com.project.backend.service.GameService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GameServiceImpl implements GameService {
    private GameRepository gameRepository;
    private static final Logger logger = LoggerFactory.getLogger(GameServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    private final String epicGamesApiUrl = "https://www.epicgames.com/store/en-US/new-releases";

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
    public List<GameDto> get8Game() {
        List<Game> games = gameRepository.findTop8Game();
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

	@Override
	public Map<String, Double> getMonthlyStatistics() {
        List<Object[]> stats = gameRepository.getMonthlyStatistics();
        Map<String, Double> data = new HashMap<>();
        for (Object[] stat : stats) {
            String gameName = (String) stat[0];
            Double total = ((Number) stat[1]).doubleValue();
            data.put(gameName, total);
        }
        return data;
    }

	@Override
	public List<Object[]> getTotalRevenueByGame() {
		// TODO Auto-generated method stub
		return null;
	}
}
