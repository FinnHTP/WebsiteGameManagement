package com.project.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne@JoinColumn(name = "accountId")
    private Account account;
    @Column(name = "date")
    private LocalDate date = LocalDate.now();
    @Column(name = "content")
    private String content;
    @Column(name = "parentId")
    private Long parentId;
    @ManyToOne @JoinColumn(name = "gameId")
    private Game game;
}
