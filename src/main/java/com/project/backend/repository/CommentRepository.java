package com.project.backend.repository;

import com.project.backend.dto.CommentDto;
import com.project.backend.entity.Account;
import com.project.backend.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepository extends JpaRepository<Comment,Long> {
//    @Query("select o from CommentDto o where accountId like ?1 and gameId like ?2")
//    CommentDto getComment(Long accountId , Long gameId);

}
