package com.project.backend.repository;

import com.project.backend.entity.GameImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameImageRepository extends JpaRepository<GameImage,Long> {
}
