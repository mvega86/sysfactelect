package com.sysfactelect.admin.service.mapper;

import com.sysfactelect.admin.persistence.entity.Role;
import com.sysfactelect.admin.service.mapper.DTO.AddRoleDTO;
import com.sysfactelect.imapper.IMapper;
import org.springframework.stereotype.Component;

@Component
public class AddRoleDTOToRole implements IMapper<AddRoleDTO, Role> {
    @Override
    public Role map(AddRoleDTO in) {
        Role role = new Role();
        role.setName(in.getName());
        return role;
    }
}
