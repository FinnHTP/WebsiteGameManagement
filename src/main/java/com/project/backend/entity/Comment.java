package com.project.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Date date = new Date();
    @Column(name = "content")
    private String content;
    @ManyToOne @JoinColumn(name = "gameId")
    private Game game;
}
