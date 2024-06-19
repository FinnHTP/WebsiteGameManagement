package com.project.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    @Column(name = "name", columnDefinition = "nvarchar(255)")
    private String name;
    @Column(name = "description_game", columnDefinition = "nvarchar(max)")
    private String description;
    @Column(name = "price")
    private Double priceGame;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "releaseDate")
    private LocalDate releaseDate;
    @Column(name = "version")
    private String version;
    @ManyToOne @JoinColumn(name = "gameTypeId")
    private GameType gameType;
    @JsonIgnore
    @OneToMany(mappedBy = "game")
    private List<OrderDetail> orderdetails;
    @Column(name = "image")
    private String image;
    @JsonIgnore
    @OneToMany(mappedBy = "game")
    private List<GameSystemRequirement> gameSystemRequirements;
    @JsonIgnore
    @OneToMany(mappedBy = "game")
    private List<Comment> comments;
    @JsonIgnore
    @OneToMany(mappedBy = "game")
    private List<KeyCode> keycodes;
    @JsonIgnore
    @OneToMany(mappedBy = "game")
    private List<Rating> ratings;



}
