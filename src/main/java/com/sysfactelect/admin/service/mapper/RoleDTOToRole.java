package com.sysfactelect.admin.service.mapper;

import com.sysfactelect.admin.persistence.entity.Role;
import com.sysfactelect.admin.service.mapper.DTO.RoleDTO;
import com.sysfactelect.imapper.IMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleDTOToRole implements IMapper<RoleDTO, Role> {
    @Override
    public Role map(RoleDTO in) {
        Role role = new Role();
        role.setId(in.getId());
        role.setName(in.getName());
        return role;
    }

   /*@Override
    public Role mapExist(RoleDTO in, Role inExist) {
        return null;
    }*/
}
