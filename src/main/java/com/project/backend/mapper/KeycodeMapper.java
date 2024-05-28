package com.project.backend.mapper;

import com.project.backend.dto.GameDto;
import com.project.backend.dto.KeyCodeDto;
import com.project.backend.entity.Game;
import com.project.backend.entity.KeyCode;

public class KeycodeMapper {
    public static KeyCodeDto mapToKeycodeDto(KeyCode keyCode){
        return new KeyCodeDto(
                keyCode.getKeyCodeId(),
                keyCode.getKeyCode(),
                keyCode.getGame(),
                keyCode.getCreateDate(),
                keyCode.getIsActive()
        );
    }

    public static KeyCode mapToKeycode(KeyCodeDto keyCodeDto){
        KeyCode keyCode = new KeyCode();
        keyCode.setKeyCodeId(keyCodeDto.getKeycodeId());
        keyCode.setKeyCode(keyCodeDto.getKeycode());
        keyCode.setGame(keyCodeDto.getGame());
        keyCode.setCreateDate(keyCodeDto.getCreateDate());
        keyCode.setIsActive(keyCodeDto.getIsActive());
        return keyCode;
    }
}
