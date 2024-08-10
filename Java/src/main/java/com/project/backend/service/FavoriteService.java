package com.project.backend.service;

import java.util.List;

import com.project.backend.dto.FavoriteDto;
import com.project.backend.entity.Favorite;

public interface FavoriteService {
    public FavoriteDto createFavorite(FavoriteDto favoriteDto);
    public FavoriteDto getFavoriteById(Long favoriteId);
    public FavoriteDto updateFavoriteById(Long favoriteId, FavoriteDto favoriteDto);
    public void deleteFavoriteById(Long favoriteId);
    public List<FavoriteDto> getAllFavorite();
//    boolean  isUserFavoriteGame(Long gameId, Long accountId);
    public List<FavoriteDto> getAllFavoriteIsActive();
public	FavoriteDto deactivateFavorite(Long id);
	
}
