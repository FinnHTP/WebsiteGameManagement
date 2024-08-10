package com.project.backend.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.backend.dto.FavoriteDto;
import com.project.backend.entity.Favorite;
import com.project.backend.entity.Game;
import com.project.backend.entity.Group;
import com.project.backend.exception.ResourceNotFoundException;
import com.project.backend.mapper.FavoriteMapper;
import com.project.backend.repository.AccountRepository;
import com.project.backend.repository.FavoriteRepository;
import com.project.backend.repository.GameRepository;
import com.project.backend.service.FavoriteService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FavoriteServiceImpl implements  FavoriteService{
    @Autowired
    private FavoriteRepository favoriteRepository;
    
  
    
    
    @Override
    public FavoriteDto createFavorite(FavoriteDto favoriteDto) {
        Favorite favorite = FavoriteMapper.MapToEntity(favoriteDto);
        Favorite savedFavorite = favoriteRepository.save(favorite);
        return FavoriteMapper.MapToDto(savedFavorite);
    }

    @Override
    public FavoriteDto getFavoriteById(Long favoriteId) {
        Favorite favorite = favoriteRepository.findById(favoriteId).orElseThrow(() -> new ResourceNotFoundException("Favorite Game not exist with id : " + favoriteId));
        return FavoriteMapper.MapToDto(favorite);
    }

    @Override
    public FavoriteDto updateFavoriteById(Long favoriteId, FavoriteDto favoriteDto) {
        Favorite favorite = favoriteRepository.findById(favoriteId).orElseThrow(() -> new ResourceNotFoundException("Favorite Game not exist with id : " + favoriteId));
        favorite.setIsActive(favoriteDto.getIsActive());
        favorite.setGame(favoriteDto.getGame());
        favorite.setAccount(favoriteDto.getAccount());
        Favorite savedFavorite = favoriteRepository.save(favorite);
        return FavoriteMapper.MapToDto(savedFavorite);
    }

    @Override
    public void deleteFavoriteById(Long favoriteId) {
        Favorite favorite = favoriteRepository.findById(favoriteId).orElseThrow(() -> new ResourceNotFoundException("Favorite Game not exist with id : " + favoriteId));
       favoriteRepository.delete(favorite);
    }

    @Override
    public List<FavoriteDto> getAllFavorite() {
        List<Favorite> favorites = favoriteRepository.findAll();
        return favorites.stream().map(favorite -> FavoriteMapper.MapToDto(favorite)).collect(Collectors.toList());
    }

	@Override
	public List<FavoriteDto> getAllFavoriteIsActive() {
		List<Favorite> favorites = favoriteRepository.getAllFavoriteIsActive();
		 return favorites.stream().map(favorite -> FavoriteMapper.MapToDto(favorite)).collect(Collectors.toList());
	}

	@Override
	public FavoriteDto deactivateFavorite(Long id) {
	    Favorite favorite = favoriteRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Favorite not found"));
	    favorite.setIsActive(false);
	    favoriteRepository.save(favorite);
	    return FavoriteMapper.MapToDto(favorite);
	}

    
}