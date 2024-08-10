package com.project.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    	
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable (name = "comment_reaction" , joinColumns = @JoinColumn  (name = "comment_id") ,inverseJoinColumns = @JoinColumn(name = "reaction_id" ))
    private List<Reaction> reactions = new ArrayList<>();
}
