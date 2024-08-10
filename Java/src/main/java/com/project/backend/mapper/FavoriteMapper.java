package com.project.backend.mapper;

import com.project.backend.dto.FavoriteDto;
import com.project.backend.entity.Favorite;

public class FavoriteMapper {
    public static FavoriteDto MapToDto(Favorite favorite){
        return new FavoriteDto(favorite.getId(), favorite.getIsActive(),favorite.getGame(),favorite.getAccount());
    }
    public static Favorite MapToEntity(FavoriteDto favoriteDto){
        return new Favorite(favoriteDto.getId(),favoriteDto.getIsActive(),favoriteDto.getGame(),favoriteDto.getAccount());
    }
    
	
}
