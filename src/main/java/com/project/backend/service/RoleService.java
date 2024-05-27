package com.project.backend.service;

import com.project.backend.dto.RoleDto;

import java.util.List;

public interface RoleService {
    RoleDto createRole(RoleDto roleDto);
    RoleDto getRoleById(Long roleId);
    RoleDto updateRole(Long roleId, RoleDto roleDto);
    List<RoleDto> getAllRole();
    void deleteRole(Long roleId);
}

