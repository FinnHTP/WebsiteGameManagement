package com.project.backend.repository;

import com.project.backend.entity.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query(value = "select * from users u where u.id = :myList", nativeQuery = true)
	User getUserById(@Param("myList") Integer number);
}
