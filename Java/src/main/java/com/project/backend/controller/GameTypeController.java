package com.project.backend.controller;

import com.project.backend.dto.GameTypeDto;
import com.project.backend.entity.GameType;
import com.project.backend.response.ResponseData;
import com.project.backend.service.GameTypeService;
import com.sun.java.accessibility.util.Translator;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/gametypes")
@Slf4j
@SecurityRequirement(name = "bearerAuth")
public class GameTypeController {
    private GameTypeService gameTypeService;

    @PostMapping
    public ResponseEntity<GameTypeDto> createGameType(@RequestBody GameTypeDto gameType){
        GameTypeDto savedGameType = gameTypeService.createGameType(gameType);
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

    @PutMapping("{id}")
    public ResponseEntity<GameTypeDto> updateGameType(@PathVariable("id") Long gameTypeId, @RequestBody GameTypeDto gameTypeDto){
        GameTypeDto updateGameType = gameTypeService.updatedGameType(gameTypeId, gameTypeDto);
        return new ResponseEntity<>(updateGameType, HttpStatus.OK);
    }





}
