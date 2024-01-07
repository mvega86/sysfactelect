package com.sysfactelect.admin.service;

import com.sysfactelect.admin.service.mapper.DTO.AddCompanyDTO;
import com.sysfactelect.admin.service.mapper.DTO.CompanyDTO;

import java.util.List;
import java.util.UUID;

public interface ICompanyService {

    public List<CompanyDTO> findAll();

    public CompanyDTO findById(UUID id);

    public void save(AddCompanyDTO addCompanyDTO);

    public void deleteById(UUID id);

    public void update(UUID id, AddCompanyDTO addCompanyDTO);

}
