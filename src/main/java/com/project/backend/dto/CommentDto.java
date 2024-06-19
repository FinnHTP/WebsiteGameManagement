package com.project.backend.dto;

import com.project.backend.entity.Account;
import com.project.backend.entity.Game;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private Long id;
    private Account account;
    private LocalDate date = LocalDate.now();
    private String content;
    private Long parentId;
    private Game game;
}
