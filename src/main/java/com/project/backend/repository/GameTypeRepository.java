package com.project.backend.repository;

import com.project.backend.entity.GameType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameTypeRepository extends JpaRepository<GameType,Long> {
}
