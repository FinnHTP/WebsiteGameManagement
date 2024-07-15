package com.project.backend.dto;

import java.time.LocalDate;
import java.util.Date;

import com.project.backend.entity.Account;
import com.project.backend.entity.Game;
import com.project.backend.entity.Group;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogDto {
	    private Long id;
	    private String content;
	    private Account account;
	    private Group group;
	    private LocalDate createDate = LocalDate.now();
	    private Boolean status;
	    private Game game;
	  
}
