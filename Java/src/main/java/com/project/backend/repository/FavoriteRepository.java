package com.project.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.project.backend.entity.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
}
