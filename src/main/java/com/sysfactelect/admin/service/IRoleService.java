package com.sysfactelect.admin.service;

import com.sysfactelect.admin.service.mapper.DTO.AddRoleDTO;
import com.sysfactelect.admin.service.mapper.DTO.RoleDTO;

import java.util.List;
import java.util.UUID;

public interface IRoleService {

    public List<RoleDTO> findAll();

    public RoleDTO findById(Long id);

    public void save(AddRoleDTO role);

    public void deleteById(Long id);

    public void update(Long id, AddRoleDTO addRoleDTO);
}
