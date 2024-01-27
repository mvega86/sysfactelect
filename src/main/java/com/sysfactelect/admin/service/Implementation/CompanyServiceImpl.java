package com.sysfactelect.admin.service.Implementation;

import com.sysfactelect.exceptions.SysFactElectException;
import com.sysfactelect.admin.persistence.entity.Company;
import com.sysfactelect.admin.persistence.repository.CompanyRepository;
import com.sysfactelect.admin.service.ICompanyService;
import com.sysfactelect.admin.service.mapper.AddCompanyDTOToCompany;
import com.sysfactelect.admin.service.mapper.CompanyDTOToCompany;
import com.sysfactelect.admin.service.mapper.CompanyToCompanyDTO;
import com.sysfactelect.admin.service.mapper.DTO.AddCompanyDTO;
import com.sysfactelect.admin.service.mapper.DTO.CompanyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CompanyServiceImpl implements ICompanyService {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CompanyToCompanyDTO companyToCompanyDTO;
    @Autowired
    private AddCompanyDTOToCompany addCompanyDTOToCompany;
    @Override
    public List<CompanyDTO> findAll() {
        return companyRepository.findAll()
                .stream()
                .map(company -> companyToCompanyDTO.map(company))
                .toList();
    }

    @Override
    public CompanyDTO findById(UUID id) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (optionalCompany.isPresent()) {
            return companyToCompanyDTO.map(optionalCompany.get());
        }
        throw new SysFactElectException("Company not found", HttpStatus.NOT_FOUND);
    }

    @Override
    public void save(AddCompanyDTO companyDTO) {
        Company company = addCompanyDTOToCompany.map(companyDTO);
        companyRepository.save(company);
    }

    @Override
    public void deleteById(UUID id) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if(optionalCompany.isPresent()) {
            companyRepository.deleteById(id);
        }else{
            throw new SysFactElectException("Company not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void update(UUID id, AddCompanyDTO addCompanyDTO) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (optionalCompany.isPresent()) {
            Company company = optionalCompany.get();
            company.setName(addCompanyDTO.getName());
            company.setAcronym(addCompanyDTO.getAcronym());
            companyRepository.save(company);
        }else {
            throw new SysFactElectException("Company not found", HttpStatus.NOT_FOUND);
        }
    }
}
