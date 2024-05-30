package com.project.backend.controller;

import com.project.backend.dto.AuthorityDto;
import com.project.backend.service.AuthorityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/authority")
public class AuthorityController {
    private AuthorityService authorityService;

    @PostMapping
    public ResponseEntity<AuthorityDto> createAuthority(@RequestBody AuthorityDto authorityDto){
        AuthorityDto newAuthority = authorityService.createAuthority(authorityDto);
        return new ResponseEntity<>(newAuthority, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AuthorityDto>> getAllAuthority(){
        List<AuthorityDto> authorityDtos = authorityService.getAllAuthority();
        return ResponseEntity.ok(authorityDtos);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAuthority(@PathVariable("id") Long id){
        authorityService.deleteAuthority(id);
        return ResponseEntity.ok("Authority delete successfully");
    }
}
