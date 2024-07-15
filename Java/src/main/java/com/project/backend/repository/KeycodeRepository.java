package com.project.backend.repository;


import com.project.backend.entity.KeyCode;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface KeycodeRepository extends JpaRepository<KeyCode,Long> {
	  @Query(value = "select * from keycodes where is_active = 1", nativeQuery = true)
	   List<KeyCode> findByStatusEnable();
	  
	  @Query(value = "select * from keycodes where is_active = 0", nativeQuery = true)
	   List<KeyCode> findByStatusDisable();
}
 