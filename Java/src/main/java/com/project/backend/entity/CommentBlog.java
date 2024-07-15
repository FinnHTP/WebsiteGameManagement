package com.project.backend.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comment_in_blog")
public class CommentBlog {
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
	    @ManyToOne @JoinColumn(name = "blogId")
	    private Blog blog;
	    
}
