package com.project.backend.dto;

import com.project.backend.entity.Game;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeyCodeDto {
    private Long id;
    private String keycode;
    private Game game;
    private LocalDate createDate = LocalDate.now();
    private Boolean isActive;
}
