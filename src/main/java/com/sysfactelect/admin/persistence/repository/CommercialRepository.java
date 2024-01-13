package com.sysfactelect.admin.persistence.repository;

import com.sysfactelect.admin.persistence.entity.Commercial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CommercialRepository extends JpaRepository<Commercial, UUID> {
}
