package com.project.backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.backend.dto.GameDto;
import com.project.backend.service.GameService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/games")
@SecurityRequirement(name = "bearerAuth")
public class GameController {
    private GameService gameService;
   

    @PostMapping
    public ResponseEntity<GameDto> createGame(@RequestBody GameDto game){
        GameDto savedGame = gameService.createGame(game);
        return new ResponseEntity<>(savedGame, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<GameDto> getGameById(@PathVariable("id") Long gameId){
        GameDto gameDto = gameService.getGameById(gameId);
        return ResponseEntity.ok(gameDto);
    }
    @GetMapping
    public ResponseEntity<List<GameDto>> getAll(){
        List<GameDto> games = gameService.getAllGame();
        return ResponseEntity.ok(games);
    }
    @GetMapping("get8Game")
    public ResponseEntity<List<GameDto>> get8Games(){
        List<GameDto> games = gameService.get8Game();
        return ResponseEntity.ok(games);
    }

    @GetMapping("/profit")
    public Map<String, Double> getRevenueData() {
        return gameService.getMonthlyStatistics();
    }
    

    @PutMapping("{id}")
    public ResponseEntity<GameDto> updateGame(@PathVariable("id") Long gameId, @RequestBody GameDto updatedGame){
        GameDto game = gameService.updateGame(gameId , updatedGame);
        return ResponseEntity.ok(game);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteGame(@PathVariable("id") Long gameId){
        gameService.deleteGame(gameId);
        return ResponseEntity.ok("Game deleted Successfully");
    }
}
