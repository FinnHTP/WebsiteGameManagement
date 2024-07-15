package com.project.backend.dto;

import java.util.Set;

import com.project.backend.entity.Account;
import com.project.backend.entity.Group;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoinGroupDto {
	private Long groupId;
	private Long accountId;
}
