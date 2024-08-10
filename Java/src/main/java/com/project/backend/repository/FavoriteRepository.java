package com.project.backend.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.backend.dto.FavoriteDto;
import com.project.backend.entity.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
	  @Query("select o from Favorite o where o.isActive = true")
	   List<Favorite> getAllFavoriteIsActive();
}
