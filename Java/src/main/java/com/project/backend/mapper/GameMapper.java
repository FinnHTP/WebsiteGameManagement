
package com.project.backend.mapper;

import com.project.backend.dto.GameDto;
import com.project.backend.entity.Game;

public class GameMapper {
    public static GameDto mapToGameDto(Game game){
        return new GameDto(
                game.getId(),
                game.getName(),
                game.getDescription(),
                game.getPriceGame(),
                game.getStatus(),
                game.getReleaseDate(),
                game.getVersion(),
                game.getImage(),
                game.getGameType(),
                game.getCoupon()
        );
    }
    public static Game mapToGame(GameDto gameDto){
        Game game = new Game();
        game.setId(gameDto.getId());
        game.setPriceGame(gameDto.getPriceGame());
        game.setGameType(gameDto.getGameType());
        game.setDescription(gameDto.getDescription());
        game.setStatus(gameDto.getStatus());
        game.setReleaseDate(gameDto.getReleaseDate());
        game.setImage(gameDto.getImage());
        game.setVersion(gameDto.getVersion());
        game.setName(gameDto.getName());
        game.setCoupon(gameDto.getCoupon());
        return game;
    }
}
