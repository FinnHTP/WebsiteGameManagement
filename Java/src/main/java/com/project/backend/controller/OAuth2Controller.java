package com.project.backend.controller;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.backend.auth.AuthenticationResponse;
import com.project.backend.entity.Account;
import com.project.backend.entity.RankAccount;
import com.project.backend.entity.Role;
import com.project.backend.entity.User;
import com.project.backend.repository.AccountRepository;
import com.project.backend.repository.RoleRepository;
import com.project.backend.service.JwtService;
import com.project.backend.utilies.RoleName;

import lombok.RequiredArgsConstructor;

@CrossOrigin("*")
@Controller
@RequiredArgsConstructor
public class OAuth2Controller {

    private final AccountRepository repository;
    private final JwtService jwtService;
    private final RoleRepository roleRepository;

    @GetMapping("/loginSuccess")
    @ResponseBody
public AuthenticationResponse getLoginInfo(Authentication authentication) {
    if (authentication == null || !(authentication instanceof OAuth2AuthenticationToken)) {
        throw new RuntimeException("Authentication information is missing or not OAuth2 authentication.");
    }

    OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
    Map<String, Object> attributes = oauthToken.getPrincipal().getAttributes();
    String email = (String) attributes.get("email");
    String name = (String) attributes.get("name");

    // Check if user already exists
    Account account = repository.findByEmail(email);
    if (account == null) {
        RankAccount rankAccount = new RankAccount();
        rankAccount.setId(1L);
        User user_account = new User();
        account = Account.builder()
                .username(email)
                .accountBalance(0.0)
                .level(1)
                .rankAccount(rankAccount)
                .password("") // Google users won't have a password
                .email(email)
                .user(user_account)
                .build();

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(RoleName.USER).orElseThrow(
                () -> new RuntimeException("Role not found"));
        roles.add(userRole);
        account.setRoles(roles);
        user_account.setAccount(account);
        repository.save(account);
    }

    var jwtToken = jwtService.generateToken(account);
    return AuthenticationResponse.builder().token(jwtToken).build();
}

}
