package com.project.backend.entity;


import java.util.HashSet;
import java.util.Set;

import com.project.backend.utilies.ReactionName;
import com.project.backend.utilies.RoleName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ReactionName name;
    



}
