package com.sysfactelect.admin.service.mapper;

import com.sysfactelect.admin.service.mapper.DTO.CompanyDTO;
import com.sysfactelect.admin.persistence.entity.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyToCompanyDTO implements IMapper<Company, CompanyDTO>{
    @Override
    public CompanyDTO map(Company in) {
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setId(in.getId());
        companyDTO.setName(in.getName());
        companyDTO.setAcronym(in.getAcronym());
        companyDTO.setUserList(in.getUserList());
        return companyDTO;
    }

    /*@Override
    public CompanyDTO mapExist(Company in, CompanyDTO inExist) {
        inExist.setId(in.getId());
        inExist.setName(in.getName());
        inExist.setAcronym(in.getAcronym());
        inExist.setUserList(in.getUserList());
        return inExist;
    }*/
}
