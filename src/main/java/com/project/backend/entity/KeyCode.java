package com.project.backend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "keycodes")
public class KeyCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long keyCodeId;
    @Column(name = "keyCode")
    private String keyCode;
    @ManyToOne @JoinColumn(name = "gameId")
    private Game game;
    @Column(name = "createDate")
    private Date createDate;
    @Column(name = "isActive")
    private Boolean isActive;
}
