package com.project.backend.dto;

import com.project.backend.entity.Account;
import com.project.backend.entity.Comment;
import com.project.backend.utilies.ReactionName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReactionDto {
    private  Long id;
     private ReactionName name;
}
