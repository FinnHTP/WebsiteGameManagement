package com.project.backend.controller;

import com.project.backend.dto.GameDto;
import com.project.backend.entity.Game;
import com.project.backend.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/games")
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
