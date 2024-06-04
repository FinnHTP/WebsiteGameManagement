package com.project.backend.service;

import com.project.backend.dto.AccountDto;
import com.project.backend.entity.Account;
import com.project.backend.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    BCryptPasswordEncoder pe;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            // Sử dụng findById với username được chuyển đổi thành kiểu Long
            Optional<Account> optionalAccount = accountRepository.findById(Long.parseLong(username));

            // Kiểm tra xem tài khoản có tồn tại không
            if (optionalAccount.isPresent()) {
                Account account = optionalAccount.get();
                // Tạo UserDetails từ Account
                String password = account.getPassword();
                String[] roles = account.getAuthorities().stream().map(au -> au.getRole().getId())
                        .toList().toArray(new String[0]);
                return User.withUsername(username).password(pe.encode(password)).roles(roles).build();
            } else {
                throw new UsernameNotFoundException(username + " not found.");
            }
        } catch (NumberFormatException e) {
            // Xử lý nếu username không phải là một số
            throw new UsernameNotFoundException(username + " not found.");
        }
    }

//    public void loginFromOAuth2(OAuth2AuthenticationToken oauth2) {
//        // String fullname = oauth2.getPrincipal().getAttribute("name");
//        String email = oauth2.getPrincipal().getAttribute("email");
//        String password = Long.toHexString(System.currentTimeMillis());
//
//        UserDetails user = User.withUsername(email).password(pe.encode(password)).roles("GUEST").build();
//        Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
//        SecurityContextHolder.getContext().setAuthentication(auth);
//    }

}
