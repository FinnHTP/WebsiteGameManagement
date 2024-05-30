package com.project.backend.repository;

import com.project.backend.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository  extends JpaRepository<Authority, Long> {
}
