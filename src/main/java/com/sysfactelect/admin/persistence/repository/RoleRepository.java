package com.sysfactelect.admin.persistence.repository;

import com.sysfactelect.admin.persistence.entity.Role;
import com.sysfactelect.admin.persistence.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
