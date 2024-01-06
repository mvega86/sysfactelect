package com.sysfactelect.admin.service.mapper;

import com.sysfactelect.admin.persistence.entity.Role;
import com.sysfactelect.admin.service.mapper.DTO.AddRoleDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AddRoleDTOToRole implements IMapper<AddRoleDTO, Role>{
    @Override
    public Role map(AddRoleDTO in) {
        Role role = new Role();
        role.setId(UUID.randomUUID());
        role.setName(in.getName());
        return role;
    }
}
