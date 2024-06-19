package com.project.backend.controller;

import com.project.backend.dto.AccountDto;
import com.project.backend.entity.Account;
import com.project.backend.entity.Role;
import com.project.backend.entity.User;
import com.project.backend.repository.AccountRepository;
import com.project.backend.service.AccountService;
import com.project.backend.service.UserService;
import com.project.backend.utilies.RoleName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RestController
public class OAuth2Controller {
    @Autowired
    private AccountService accountService;

    @RestController
    public class MyController {
        @Autowired
        private AccountRepository accountRepository;
        @Autowired
        private AccountService accountService;
        @Autowired
        private UserService userService;
        @GetMapping("/oauth2")
        public ResponseEntity<?> getUser(@AuthenticationPrincipal OAuth2User oAuth2User) {
            Set<Role> roles = new HashSet<>();
            roles.add(new Role(3L, RoleName.USER));
            Account account = new Account();
            User user = new User();
            account.setEmail(oAuth2User.getAttribute("email"));
            account.setPassword("1234");
            account.setUser(user);
            account.setRoles(roles);
            user.setFirstName(oAuth2User.getAttribute("family_name"));
            user.setLastName(oAuth2User.getAttribute("given_name"));
            user.setAccount(account);

            if (accountRepository.findByEmail(oAuth2User.getAttribute("email").toString()) == null) {
                accountService.createAccountEmail(account);



            } else {
                // Xác định URL mà bạn muốn redirect tới trong trường hợp else
                String redirectUrl = "http://localhost:3000";

                try {
                    // Tạo URI từ URL
                    URI uri = new URI(redirectUrl);
                    // Trả về một redirect ResponseEntity
                    return ResponseEntity.status(302).location(uri).build();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                    // Trả về lỗi nếu có vấn đề khi tạo URI
                    return ResponseEntity.badRequest().build();
                }
            }
            String redirectUrl = "http://localhost:3000";
            try {
                URI uri = new URI(redirectUrl);
                // Nếu không phải vòng if hoặc else, trả về các thuộc tính OAuth2User
                return ResponseEntity.status(302).location(uri).build();
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
            
        }
    }

}