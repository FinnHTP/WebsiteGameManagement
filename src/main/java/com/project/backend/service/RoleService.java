package com.project.backend.service;

import com.project.backend.dto.RoleDto;

import java.util.List;

public interface RoleService {
    RoleDto createRole(RoleDto roleDto);
    RoleDto getRoleById(String roleId);
    RoleDto updateRole(String roleId, RoleDto roleDto);
    List<RoleDto> getAllRole();
    void deleteRole(String roleId);
}

