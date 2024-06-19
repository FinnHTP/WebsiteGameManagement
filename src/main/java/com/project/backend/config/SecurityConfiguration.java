//package com.project.backend.config;
//
//import com.project.backend.utilies.RoleName;
//import jakarta.servlet.Filter;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class SecurityConfiguration {
//    private static final String[] WHITE_LIST_URL = { "/api/v1/auth/**", "/v2/api-docs", "/v3/api-docs",
//            "/v3/api-docs/**", "/swagger-resources", "/swagger-resources/**", "/configuration/ui",
//            "/configuration/security", "/swagger-ui/**", "/webjars/**", "/swagger-ui.html", "/api/auth/**",
//            "/api/test/**", "/authenticate" };
//
//
//    private final JwtAuthenticationFilter jwtAuthFilter;
//    private final AuthenticationProvider authenticationProvider;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable())
//
//                .authorizeHttpRequests(authorize -> authorize.requestMatchers(WHITE_LIST_URL).permitAll()
//                        .requestMatchers(
//                        "/api/v1/auth/**",
//                                "/api/password/**"
//
//                                ).permitAll()
//
////                        .requestMatchers("/api/**").hasAuthority(String.valueOf(RoleName.ADMIN))
//                        .anyRequest().authenticated())
//                .sessionManagement(session -> session // Sử dụng cấu hình mặc định cho session management
//                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
//                        .authenticationProvider(authenticationProvider)
//                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
//        return http.build();
//    }
//}
