package com.project.backend.dto;

import java.time.LocalDate;
import java.util.Set;

import com.project.backend.entity.Account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupDto {
	    private Long id;
	    private String name;
	    private String image;
	    private boolean status;
	    private LocalDate createDate;
}
