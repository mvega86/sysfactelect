package com.sysfactelect.admin.service;

import com.sysfactelect.admin.service.mapper.DTO.AddRoleDTO;
import com.sysfactelect.admin.service.mapper.DTO.RoleDTO;

import java.util.List;
import java.util.UUID;

public interface IRoleService {

    public List<RoleDTO> findAll();

    public RoleDTO findById(UUID id);

    public void save(AddRoleDTO role);

    public void deleteById(UUID id);

    public void update(RoleDTO role, AddRoleDTO addRoleDTO);
}
