package com.project.backend.controller;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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

    private static final int MAX_RETRY_ATTEMPTS = 3;
    private static final long RETRY_DELAY_MS = 1000; // 1 second

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

        // Attempt to fetch account, retry on 999 error
        Account account = null;
        int retryAttempts = 0;
        while (retryAttempts < MAX_RETRY_ATTEMPTS) {
            try {
                account = repository.findByEmail(email);
                if (account != null) {
                    break;
                }

                // Create a new account if not found
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

                // Save the new account
                repository.save(account);
                break; // Exit retry loop upon successful save
            } catch (RuntimeException e) {
                // Handle specific exceptions if needed
                // For example, handle duplicate key exceptions
                // Log the error for debugging purposes
                e.printStackTrace();

                // Increment retry attempts
                retryAttempts++;

                // Wait before retrying
                try {
                    TimeUnit.MILLISECONDS.sleep(RETRY_DELAY_MS);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        if (account == null) {
            throw new RuntimeException("Failed to fetch or create account for user: " + email);
        }

        // Generate JWT token
        var jwtToken = jwtService.generateToken(account);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

}
