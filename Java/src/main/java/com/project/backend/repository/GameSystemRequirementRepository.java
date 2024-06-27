package com.project.backend.repository;

import com.project.backend.entity.Comment;
import com.project.backend.entity.GameSystemRequirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameSystemRequirementRepository extends JpaRepository<GameSystemRequirement, Long> {
    @Query("select o from GameSystemRequirement o where o.game.id = ?1")
    List<GameSystemRequirement> findByGame(Long gameId);
}
