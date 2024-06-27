package com.project.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.backend.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    @Query("select o from Comment o where o.game.id = ?1")
   List<Comment> findByGame(Long gameId);

   @Query("select o from Comment o where o.account.id = ?1")
   List<Comment> findByAccount(Long accountId);
   

}
