package com.project.backend.mapper;

import com.project.backend.dto.RoleDto;
import com.project.backend.entity.Role;

public class RoleMapper {
    public static RoleDto MaptoRoleDto(Role role){
        RoleDto roleDto = new RoleDto();
        roleDto.setId(role.getId());
        roleDto.setName(role.getName());
        return roleDto;
    }
    public static Role MapToRole(RoleDto roleDto){
        Role role = new Role();
        role.setId(roleDto.getId());
        role.setName(roleDto.getName());
        return role;
    }
}
