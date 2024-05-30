package com.project.backend.service;

import com.project.backend.dto.AuthorityDto;

import java.util.List;

public interface AuthorityService  {
    AuthorityDto createAuthority(AuthorityDto authorityDto);
    List<AuthorityDto> getAllAuthority();
    void deleteAuthority(Long id);
}
