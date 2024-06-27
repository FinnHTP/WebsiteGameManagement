package com.project.backend.repository;

import com.project.backend.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    @Query(value = "SELECT TOP 8 * FROM games", nativeQuery = true)
    List<Game> findTop8Game();
}
