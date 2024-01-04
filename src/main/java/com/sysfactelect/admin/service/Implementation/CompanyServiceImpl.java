package com.sysfactelect.admin.service.Implementation;

import com.sysfactelect.admin.persistence.entity.Company;
import com.sysfactelect.admin.persistence.repository.CompanyRepository;
import com.sysfactelect.admin.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements ICompanyService {

    @Autowired
    private CompanyRepository companyRepository;
    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public List<Company> deleteById(Long id) {
        companyRepository.deleteById(id);
        return findAll();
    }
}
