package com.sysfactelect.admin.service.mapper;

import com.sysfactelect.admin.persistence.entity.Role;
import com.sysfactelect.admin.service.mapper.DTO.RoleByUserDTO;
import org.springframework.stereotype.Component;

@Component
public class RoleToRoleByUserDTO implements IMapper<Role, RoleByUserDTO>{

    @Override
    public RoleByUserDTO map(Role in) {
        return new RoleByUserDTO(
                in.getId(),
                in.getName()
        );
    }
}
