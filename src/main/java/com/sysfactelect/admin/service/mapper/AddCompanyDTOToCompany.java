package com.sysfactelect.admin.service.mapper;

import com.sysfactelect.admin.persistence.entity.Company;
import com.sysfactelect.admin.service.mapper.DTO.AddCompanyDTO;
import com.sysfactelect.imapper.IMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AddCompanyDTOToCompany implements IMapper<AddCompanyDTO, Company> {
    @Override
    public Company map(AddCompanyDTO in) {
        Company company = new Company();
        company.setId(UUID.randomUUID());
        company.setName(in.getName());
        company.setAcronym(in.getAcronym());
        return company;
    }
}
