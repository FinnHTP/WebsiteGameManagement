package com.project.backend.repository;


import com.project.backend.entity.Role;
import com.project.backend.utilies.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, String> {
    Optional<Role> findByName(RoleName roleName);
}
