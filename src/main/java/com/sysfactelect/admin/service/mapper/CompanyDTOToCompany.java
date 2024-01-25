package com.sysfactelect.admin.service.mapper;

import com.sysfactelect.admin.service.mapper.DTO.CompanyDTO;
import com.sysfactelect.admin.persistence.entity.Company;
import com.sysfactelect.imapper.IMapper;
import org.springframework.stereotype.Component;

@Component
public class CompanyDTOToCompany implements IMapper<CompanyDTO, Company> {
    @Override
    public Company map(CompanyDTO in) {
        Company company = new Company();
        company.setId(in.getId());
        company.setName(in.getName());
        company.setAcronym(in.getAcronym());
        company.setUserList(in.getUserList());
        return company;
    }

    /*@Override
    public Company mapExist(CompanyDTO in, Company inExist) {
        inExist.setId(in.getId());
        inExist.setName(in.getName());
        inExist.setAcronym(in.getAcronym());
        inExist.setUserList(in.getUserList());
        return inExist;
    }*/
}
