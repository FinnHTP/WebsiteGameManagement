package com.project.backend.repository;


import com.project.backend.entity.Account;
import com.project.backend.entity.Comment;
import com.project.backend.entity.Reaction;
import com.project.backend.utilies.ReactionName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReactionRepository extends JpaRepository<Reaction, Long> {
	@Query(value = "select count(comment_id) from reaction_comment where comment_id= :commentId ", nativeQuery = true)
	Long getReactionComment(Long commentId);
	
}

