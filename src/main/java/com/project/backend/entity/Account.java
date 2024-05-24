package com.project.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "userName")
    private String userName;
    @Column(name = "level")
    private Integer level;
    @Column(name = "password")
    private String password;
    @ManyToOne @JoinColumn(name = "rankAccountId")
    private RankAccount rankAccount;
    @Column(name = "accountBalance")
    private Double accountBalance;
    @Column(name = "email")
    private String email;
    @JsonIgnore
    @OneToMany(mappedBy = "account")
    private List<User> user;
    @JsonIgnore
    @OneToMany(mappedBy = "account")
    private List<Authority> authorities;
    @JsonIgnore
    @OneToMany(mappedBy = "account")
    private List<Deposit> deposits;
    @JsonIgnore
    @OneToMany(mappedBy = "account")
    private List<ProfileAccount> profileAccount;
    @JsonIgnore
    @OneToMany(mappedBy = "account")
    private List<Comment> comments;
    @JsonIgnore
    @OneToMany(mappedBy = "account")
    private List<Rating> ratings;

}
