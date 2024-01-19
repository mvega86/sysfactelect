package com.sysfactelect.admin.service.Implementation;

import com.sysfactelect.exceptions.exceptions.SysFactElectException;
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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return roleRepository.findAll()
                .stream()
                .map(role -> roleToRoleDTO.map(role))
                .toList();
    }
    @Override
    public RoleDTO findById(Long id) {
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
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public void update(Long id, AddRoleDTO addRoleDTO) {
        Optional<Role> optionalRole = roleRepository.findById(id);
        if (optionalRole.isPresent()) {
            Role role = optionalRole.get();
            role.setName(addRoleDTO.getName());
            roleRepository.save(role);
        }else {
            throw new SysFactElectException("Role not found", HttpStatus.NOT_FOUND);
        }
    }
}
