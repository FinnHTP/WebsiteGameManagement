package com.project.backend.controller;

import com.project.backend.dto.GameDto;
import com.project.backend.dto.GameImageDto;
import com.project.backend.service.GameImageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/GameImages")
public class GameImageController {
    private GameImageService service;

    @PostMapping
    public ResponseEntity<GameImageDto> createGame(@RequestBody GameImageDto imageDto){
        GameImageDto savedGameImage = service.createGameimage(imageDto);
        return new ResponseEntity<>(savedGameImage, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<GameImageDto> getGameImageById(@PathVariable("id") Long ImageId){
        GameImageDto imageDto = service.getGameImageById(ImageId);
        return ResponseEntity.ok(imageDto);
    }
    @GetMapping
    public ResponseEntity<List<GameImageDto>> getAll(){
        List<GameImageDto> imageDtos = service.getAllGameImage();
        return ResponseEntity.ok(imageDtos);
    }
    @PutMapping("{id}")
    public ResponseEntity<GameImageDto> updateGameImae(@PathVariable("id") Long ImageId, @RequestBody GameImageDto imageDto){
        GameImageDto gameImageDto = service.updateGameImage(ImageId , imageDto);
        return ResponseEntity.ok(gameImageDto);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteGame(@PathVariable("id") Long ImageId){
        service.deleteGameImage(ImageId);
        return ResponseEntity.ok("Game deleted Successfully");
    }
}
