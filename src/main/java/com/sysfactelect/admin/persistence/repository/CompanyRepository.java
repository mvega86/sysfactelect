package com.sysfactelect.admin.persistence.repository;

import com.sysfactelect.admin.persistence.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
