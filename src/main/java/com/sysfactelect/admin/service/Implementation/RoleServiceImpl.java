package com.sysfactelect.admin.service.Implementation;

import com.sysfactelect.admin.persistence.entity.Role;
import com.sysfactelect.admin.persistence.repository.RoleRepository;
import com.sysfactelect.admin.service.IRoleService;
import com.sysfactelect.admin.service.mapper.AddRoleDTOToRole;
import com.sysfactelect.admin.service.mapper.DTO.AddRoleDTO;
import com.sysfactelect.admin.service.mapper.DTO.RoleDTO;
import com.sysfactelect.admin.service.mapper.RoleDTOToRole;
import com.sysfactelect.admin.service.mapper.RoleToRoleDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private AddRoleDTOToRole addRoleDTOToRole;
    @Autowired
    private RoleToRoleDTO roleToRoleDTO;
    @Autowired
    private RoleDTOToRole roleDTOToRole;
    @Override
    public List<RoleDTO> findAll() {
        List<RoleDTO> roleDTOList = roleRepository.findAll()
                .stream()
                .map(role -> roleToRoleDTO.map(role))
                .toList();
        return roleDTOList;
    }

    @Override
    public RoleDTO findById(UUID id) {
        if (roleRepository.findById(id).isPresent()){
            Role role = roleRepository.findById(id).get();
            return roleToRoleDTO.map(role);
        }
        throw new EntityNotFoundException("Role not found");
    }

    @Override
    public void save(AddRoleDTO roleDTO) {
        roleRepository.save(addRoleDTOToRole.map(roleDTO));
    }

    @Override
    public void deleteById(UUID id) {
        roleRepository.deleteById(id);
    }

    @Override
    public void update(RoleDTO roleDTO, AddRoleDTO addRoleDTO) {
        roleDTO.setName(addRoleDTO.getName());
        roleRepository.save(roleDTOToRole.map(roleDTO));
    }
}
