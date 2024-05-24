package com.project.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "authorities" , uniqueConstraints = {
        @UniqueConstraint(columnNames = {"userName", "roleId"})
})
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne @JoinColumn(name = "accountId")
    private Account account;
    @ManyToOne @JoinColumn(name = "roleId")
    private Role role;
}
