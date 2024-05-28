package com.project.backend.dto;

import com.project.backend.entity.Game;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeyCodeDto {
    private Long KeycodeId;
    private String Keycode;
    private Game game;
    private Date createDate;
    private Boolean isActive;
}
