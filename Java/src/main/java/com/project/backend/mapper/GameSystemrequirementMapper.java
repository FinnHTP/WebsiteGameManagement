package com.project.backend.mapper;
import com.project.backend.dto.GameSystemRequirementDto;
import com.project.backend.entity.GameSystemRequirement;

public class GameSystemrequirementMapper {
    public static GameSystemRequirementDto mapToGameSystemRequirementDto(GameSystemRequirement gameSystemRequirement) {
        return new GameSystemRequirementDto(
                gameSystemRequirement.getId(),
                gameSystemRequirement.getGame(),
                gameSystemRequirement.getOs(),
                gameSystemRequirement.getMemory(),
                gameSystemRequirement.getCard(),
                gameSystemRequirement.getProccessor(),
                gameSystemRequirement.getStorage()
        );
    }
    public static GameSystemRequirement mapToGameSystemRequirement(GameSystemRequirementDto gameSystemRequirementDto){
        GameSystemRequirement gameSystemRequirement = new GameSystemRequirement();
        gameSystemRequirement.setId(gameSystemRequirementDto.getId());
        gameSystemRequirement.setGame(gameSystemRequirementDto.getGame());
        gameSystemRequirement.setOs(gameSystemRequirementDto.getOs());
        gameSystemRequirement.setMemory(gameSystemRequirementDto.getMemory());
        gameSystemRequirement.setCard(gameSystemRequirementDto.getCard());
        gameSystemRequirement.setProccessor(gameSystemRequirementDto.getProccessor());
        gameSystemRequirement.setStorage(gameSystemRequirementDto.getStorage());
        return gameSystemRequirement;
    }
}
