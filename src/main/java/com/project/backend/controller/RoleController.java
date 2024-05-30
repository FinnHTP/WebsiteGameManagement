package com.project.backend.controller;

import com.project.backend.dto.RoleDto;
import com.project.backend.service.RoleService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/roles")
public class RoleController {
    private RoleService roleService;

    @PostMapping
    public ResponseEntity<RoleDto> createRole(@RequestBody RoleDto roleDto){
        RoleDto savedRole = roleService.createRole(roleDto);
        return new ResponseEntity<>(savedRole , HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<RoleDto> getRoleById(@PathVariable("id") String roleId){
        RoleDto role = roleService.getRoleById(roleId);
        return ResponseEntity.ok(role);
    }
<<<<<<< HEAD
    @PutMapping("{id}")
    public ResponseEntity<RoleDto> updatedRole(@PathVariable("id") String roleId, @RequestBody RoleDto roleDto){
        RoleDto savedRole = roleService.updateRole(roleId, roleDto);
        return ResponseEntity.ok(savedRole);
    }
=======

>>>>>>> origin/user-acount-crud-api
    @GetMapping("")
    public ResponseEntity<List<RoleDto>> getAllRole(){
        List<RoleDto> roles = roleService.getAllRole();
        return ResponseEntity.ok(roles);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRoleById(@PathVariable("id") String roleId){
        roleService.deleteRole(roleId);
        return ResponseEntity.ok("Role Deleted Successfully");
    }

    @PutMapping("{id}")
    public ResponseEntity<RoleDto> updateRole(@PathVariable("id") String id, @RequestBody RoleDto roleDto){
        RoleDto newRoleDto = roleService.updateRole(id, roleDto);
        return new ResponseEntity<>(newRoleDto, HttpStatus.OK);
    }
}
