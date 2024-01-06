package com.sysfactelect.admin.service.mapper;

import com.sysfactelect.admin.service.mapper.DTO.RoleDTO;
import com.sysfactelect.admin.persistence.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleToRoleDTO implements IMapper<Role, RoleDTO>{
    @Override
    public RoleDTO map(Role in) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(in.getId());
        roleDTO.setName(in.getName());
        roleDTO.setUserList(in.getUserList());
        return roleDTO;
    }

    /*@Override
    public RoleDTO mapExist(Role in, RoleDTO inExist) {
        inExist.setId(in.getId());
        inExist.setName(in.getName());
        inExist.setUserList(in.getUserList());
        return inExist;
    }*/
}
