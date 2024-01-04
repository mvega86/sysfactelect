package com.sysfactelect.admin.controller.mapper;

import com.sysfactelect.admin.controller.mapper.DTO.CompanyDTO;
import com.sysfactelect.admin.persistence.entity.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyDTOToCompany implements IMapper<CompanyDTO, Company>{
    @Override
    public Company map(CompanyDTO in) {
        Company company = new Company();
        company.setName(in.getName());
        company.setAcronym(in.getAcronym());
        company.setUserList(in.getUserList());
        return company;
    }

    @Override
    public Company mapExist(CompanyDTO in, Company inExist) {
        inExist.setName(in.getName());
        inExist.setAcronym(in.getAcronym());
        inExist.setUserList(in.getUserList());
        return inExist;
    }
}
