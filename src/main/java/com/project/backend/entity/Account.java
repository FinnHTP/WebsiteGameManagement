package com.project.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "accounts")
public class Account implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "level")
    private Integer level;
    @Column(name = "password")
    private String password;
    @ManyToOne @JoinColumn(name = "rankAccountId")
    private RankAccount rankAccount;
    @Column(name = "accountBalance")
    private Double accountBalance;
    @Column(name = "email", unique = true)
    @Email
    private String email;
    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable (name = "user_roles", joinColumns = @JoinColumn (name = "account_id"), inverseJoinColumns = @JoinColumn (name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    @OneToOne (cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn (name = "user_id", referencedColumnName = "id")
    private User user;
    @JsonIgnore
    @OneToMany(mappedBy = "account")
    private List<Deposit> deposits;
    @JsonIgnore
    @OneToMany(mappedBy = "account")
    private List<Comment> comments;
    @JsonIgnore
    @OneToMany(mappedBy = "account")
    private List<Rating> ratings;
    @JsonIgnore
    @OneToMany (mappedBy = "account")
    private List<OTP> otpList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName().toString())).collect(
                Collectors.toList());
    }

    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
