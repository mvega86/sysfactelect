package com.sysfactelect.admin.service;

import com.sysfactelect.admin.persistence.entity.Company;

import java.util.List;
import java.util.Optional;

public interface ICompanyService {

    public List<Company> findAll();

    public Optional<Company> findById(Long id);

    public Company save(Company company);

    public List<Company> deleteById(Long id);

}
