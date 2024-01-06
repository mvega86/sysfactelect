package com.sysfactelect.admin.service.Implementation;

import com.sysfactelect.admin.persistence.entity.Company;
import com.sysfactelect.admin.persistence.repository.CompanyRepository;
import com.sysfactelect.admin.service.ICompanyService;
import com.sysfactelect.admin.service.mapper.AddCompanyDTOToRole;
import com.sysfactelect.admin.service.mapper.CompanyDTOToCompany;
import com.sysfactelect.admin.service.mapper.CompanyToCompanyDTO;
import com.sysfactelect.admin.service.mapper.DTO.AddCompanyDTO;
import com.sysfactelect.admin.service.mapper.DTO.CompanyDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CompanyServiceImpl implements ICompanyService {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CompanyDTOToCompany companyDTOToCompany;
    @Autowired
    private CompanyToCompanyDTO companyToCompanyDTO;

    @Autowired
    private AddCompanyDTOToRole addCompanyDTOToRole;
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
        throw new EntityNotFoundException("Campany not found");
    }

    @Override
    public void save(AddCompanyDTO companyDTO) {
        Company company = addCompanyDTOToRole.map(companyDTO);
        companyRepository.save(company);
    }

    @Override
    public void deleteById(UUID id) {
        companyRepository.deleteById(id);
    }

    @Override
    public void update(CompanyDTO companyDTO, AddCompanyDTO addCompanyDTO) {
        companyDTO.setName(addCompanyDTO.getName());
        companyDTO.setAcronym(addCompanyDTO.getAcronym());
        Company company = companyDTOToCompany.map(companyDTO);
        companyRepository.save(company);
    }
}
