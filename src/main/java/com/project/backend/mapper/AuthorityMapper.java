package com.project.backend.mapper;

import com.project.backend.dto.AuthorityDto;
import com.project.backend.entity.Account;
import com.project.backend.entity.Authority;
import com.project.backend.entity.Role;

import java.util.List;

public class AuthorityMapper {
    public static AuthorityDto MapToAuthorityDto(Authority authority){
        AuthorityDto authorityDto = new AuthorityDto();
        authorityDto.setId(authority.getId());
        authorityDto.setAccountId(authority.getAccount().getId());
        authorityDto.setRoleId(authority.getRole().getId());
        return authorityDto;
    }
    public static Authority MapToAuthority(AuthorityDto authorityDto){
        Authority authority = new Authority();
        // Set properties for Authority ID
        authority.setId(authorityDto.getId());
        // Set properties for Account ID
        Account account = new Account();
        account.setId(authorityDto.getAccountId());
        authority.setAccount(account);
        // Set properties for Role ID
        Role role = new Role();
        role.setId(authorityDto.getRoleId());
        authority.setRole(role);
        return authority;
    }
}
