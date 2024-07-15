package com.project.backend.dto;

import java.time.LocalDate;

import com.project.backend.entity.Account;
import com.project.backend.entity.Blog;
import com.project.backend.entity.Game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentBlogDto {
    private Long id;
    private Account account;
    private LocalDate date = LocalDate.now();
    private String content;
    private Long parentId;
    private Game game;
    private Blog blog;
}
