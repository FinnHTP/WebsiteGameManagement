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
@Table(name = "imagegames")
public class GameImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "image")
    private String nameImage;
    @ManyToOne @JoinColumn(name = "gameId")
    private Game game;
    @Column(name = "date")
    private LocalDate date;


}
