package com.project.backend.service.impl;

import com.project.backend.dto.AuthorityDto;
import com.project.backend.entity.Account;
import com.project.backend.entity.Authority;
import com.project.backend.entity.Role;
import com.project.backend.exception.ResourceNotFoundException;
import com.project.backend.mapper.AuthorityMapper;
import com.project.backend.repository.AccountRepository;
import com.project.backend.repository.AuthorityRepository;
import com.project.backend.repository.RoleRepository;
import com.project.backend.service.AuthorityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthorityServiceImpl implements AuthorityService {
    private AuthorityRepository authorityRepository;
    private RoleRepository roleRepository;
    private AccountRepository accountRepository;

    @Override
    public AuthorityDto createAuthority(AuthorityDto authorityDto) {
        // Map AuthorityDto
        Authority authority = AuthorityMapper.MapToAuthority(authorityDto);
        // Save the authority
        Authority newAuthority = authorityRepository.save(authority);
        return AuthorityMapper.MapToAuthorityDto(newAuthority);
    }

    @Override
    public List<AuthorityDto> getAllAuthority() {
        List<Authority> authorities = authorityRepository.findAll();
        return authorities.stream().map((authority) -> AuthorityMapper.MapToAuthorityDto(authority)).collect(Collectors.toList());
    }

    @Override
    public void deleteAuthority(Long id) {
        Authority authority = authorityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Authority can't be found with given id " + id));
        authorityRepository.deleteById(id);
    }
}
