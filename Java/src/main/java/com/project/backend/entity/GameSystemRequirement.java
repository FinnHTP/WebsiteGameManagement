package com.project.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gamesystemrequirements")
public class GameSystemRequirement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne @JoinColumn(name = "gameId")
    private Game game;
    @Column(name = "os")
    private String os;
    @Column(name = "processor")
    private String proccessor;
    @Column(name = "memory")
    private String memory;
    @Column(name = "storage")
    private String storage;
    @Column(name = "card")
    private String card;

}
