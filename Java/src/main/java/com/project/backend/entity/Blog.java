package com.project.backend.entity;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "blog")
public class Blog {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	  
	    @Column(name = "content")
	    private String content;
	    
	    @Column(name = "createdate")
	    private LocalDate createDate;
	    
	    @Column(name = "status")
	    private Boolean status;
	    
	    
	    @ManyToOne
	    @JoinColumn(name = "account_id")
	    @JsonIgnore
	    private Account account;
	    
	    @ManyToOne
	    @JoinColumn(name = "group_id")
	    @JsonIgnore
	    private Group group;
	    
	    @ManyToOne
	    @JoinColumn(name = "game_id")
	    @JsonIgnore
	    private Game game;
}
