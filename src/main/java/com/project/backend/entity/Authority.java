package com.project.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "authorities" , uniqueConstraints = {
        @UniqueConstraint(columnNames = {"accountId", "roleId"})
})
public class Authority implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn (name = "accountID")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role;
}
