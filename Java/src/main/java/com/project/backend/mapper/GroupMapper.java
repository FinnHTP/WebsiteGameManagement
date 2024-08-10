package com.project.backend.mapper;

import com.project.backend.dto.DepositDto;
import com.project.backend.dto.GroupDto;
import com.project.backend.entity.Deposit;
import com.project.backend.entity.Group;

public class GroupMapper {
	   public static Group mapToEntity(GroupDto GroupDto){
	        Group gr = new Group();
	        gr.setId(GroupDto.getId());
	        gr.setNamegroup(GroupDto.getName());
	        gr.setImage(GroupDto.getImage());
	        gr.setStatus(GroupDto.isStatus());
	        gr.setCreateDate(GroupDto.getCreateDate());
	        return gr;
	    }

	    public static GroupDto mapToDTO(Group group){
	        GroupDto groupDto = new GroupDto();
	        groupDto.setId(group.getId());
	        groupDto.setName(group.getNamegroup());
	        groupDto.setImage(group.getImage());
	        groupDto.setStatus(group.isStatus());
	        groupDto.setCreateDate(group.getCreateDate());
	        return groupDto;
	    }
}
