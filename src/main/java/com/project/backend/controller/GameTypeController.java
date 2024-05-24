package com.project.backend.controller;

import com.project.backend.dto.GameTypeDto;
import com.project.backend.entity.GameType;
import com.project.backend.service.GameTypeService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/gametypes")
public class GameTypeController {
    private GameTypeService gameTypeService;

    @PostMapping
    public ResponseEntity<GameTypeDto> createGameType(@RequestBody GameTypeDto gameType){
        GameTypeDto savedGameType = gameTypeService.createGameType(new GameTypeDto());
        return new ResponseEntity<>(savedGameType, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<GameTypeDto> getGameTypeById(@PathVariable("id") Long gameTypeId){
        GameTypeDto gameType = gameTypeService.getGameTypeById(gameTypeId);
        return ResponseEntity.ok(gameType);
    }
    @GetMapping
    public ResponseEntity<List<GameTypeDto>> getAllGameTypes(){
        List<GameTypeDto> gameTypes = gameTypeService.getAllGameType();
        return ResponseEntity.ok(gameTypes);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteGameType(@PathVariable("id") Long gameTypeId){
        gameTypeService.deleteGameType(gameTypeId);
        return ResponseEntity.ok("GameType Deleted Successfully");
    }

}
