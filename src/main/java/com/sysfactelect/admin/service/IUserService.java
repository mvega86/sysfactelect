package com.sysfactelect.admin.service;


import com.sysfactelect.admin.persistence.entity.Role;
import com.sysfactelect.admin.service.mapper.DTO.AddUserDTO;
import com.sysfactelect.admin.service.mapper.DTO.RoleByUserDTO;
import com.sysfactelect.admin.service.mapper.DTO.RoleDTO;
import com.sysfactelect.admin.service.mapper.DTO.UserDTO;

import java.util.List;
import java.util.UUID;

public interface IUserService {

    public List<UserDTO> findAll();

    public UserDTO findById(UUID id);

    public void save(AddUserDTO addUserDTO);

    public void deleteById(UUID id);

    public void update(UUID id, AddUserDTO addUserDTO);

    public void addUserRole(UUID id, List<Long> rolesDTO);

    public List<RoleByUserDTO> getRoles(UUID id);
}
