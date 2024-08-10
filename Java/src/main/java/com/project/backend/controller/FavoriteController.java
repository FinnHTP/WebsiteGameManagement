package com.project.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.backend.dto.FavoriteDto;
import com.project.backend.service.FavoriteService;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;
    @GetMapping("")
    public ResponseEntity<List<FavoriteDto>> getListFavorite() {
        List<FavoriteDto> favorites = favoriteService.getAllFavorite();
        return new ResponseEntity<>(favorites, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<FavoriteDto> getFavoriteById(@PathVariable("id") Long favoriteId) {
        FavoriteDto favoriteDto = favoriteService.getFavoriteById(favoriteId);
        return ResponseEntity.ok(favoriteDto);
    }

    @PostMapping
    public ResponseEntity<FavoriteDto> createFavorite(@RequestBody FavoriteDto favoriteDto) {
        FavoriteDto savedFavoriteDto = favoriteService.createFavorite(favoriteDto);
        return new ResponseEntity<>(savedFavoriteDto, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<FavoriteDto> putMethodName(@PathVariable("id") Long favoriteId, @RequestBody FavoriteDto favoriteDto) {
        FavoriteDto savedFavoriteDto = favoriteService.updateFavoriteById(favoriteId, favoriteDto);
        return new ResponseEntity<>(savedFavoriteDto, HttpStatus.OK);
    }
    
    @GetMapping("/isactive")
    public ResponseEntity<List<FavoriteDto>> getListFavoriteisActive() {
        List<FavoriteDto> favorites = favoriteService.getAllFavoriteIsActive();
        return new ResponseEntity<>(favorites, HttpStatus.OK);
    }
    
    @PutMapping("/{id}/unlike")
    public ResponseEntity<FavoriteDto> deactivateFavorite(@PathVariable Long id) {
        FavoriteDto updatedFavorite = favoriteService.deactivateFavorite(id);
        return ResponseEntity.ok(updatedFavorite);
    }

}