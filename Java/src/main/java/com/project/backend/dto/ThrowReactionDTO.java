package com.project.backend.dto;

import com.project.backend.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThrowReactionDTO {
    private Long accountId;
    private Long commentId;
    private Long reactionId;
}
