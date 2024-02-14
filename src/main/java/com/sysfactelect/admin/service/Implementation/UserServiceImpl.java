package com.sysfactelect.admin.service.Implementation;

import com.sysfactelect.exceptions.SysFactElectException;
import com.sysfactelect.admin.persistence.entity.Company;
import com.sysfactelect.admin.persistence.entity.Role;
import com.sysfactelect.admin.persistence.entity.User;
import com.sysfactelect.admin.persistence.repository.CompanyRepository;
import com.sysfactelect.admin.persistence.repository.RoleRepository;
import com.sysfactelect.admin.persistence.repository.UserRepository;
import com.sysfactelect.admin.service.IUserService;
import com.sysfactelect.admin.service.mapper.*;
import com.sysfactelect.admin.service.mapper.DTO.AddUserDTO;
import com.sysfactelect.admin.service.mapper.DTO.RoleByUserDTO;
import com.sysfactelect.admin.service.mapper.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserToUserDTO userToUserDTO;
    @Autowired
    private RoleToRoleByUserDTO roleToRoleByUserDTO;
    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(user -> userToUserDTO.map(user))
                .toList();
    }

    @Override
    public UserDTO findById(UUID id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()) {
            return userToUserDTO.map(optionalUser.get());
        }
        throw new SysFactElectException("User not found", HttpStatus.NOT_FOUND);
    }

    @Override
    public void deleteById(UUID id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()) {
            userRepository.deleteById(id);
        }else {
            throw new SysFactElectException("User not found", HttpStatus.NOT_FOUND);
        }
    }


    @Override
    public void update(UUID id, AddUserDTO addUserDTO) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUsername(addUserDTO.getUsername());
            user.setPassword(addUserDTO.getPassword());
            user.setEmail(addUserDTO.getEmail());
            user.setName(addUserDTO.getName());
            user.setLastname(addUserDTO.getLastname());
            user.setCompany(addUserDTO.getCompany());
            userRepository.save(user);
        }else {
            throw new SysFactElectException("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void addUserRole(UUID id, List<Long> rolesIDs) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            for (Long roleID : rolesIDs) {
                Optional<Role> role = roleRepository.findById(roleID);
                if (role.isPresent()) {
                    user.addRole(role.get());
                } else {
                    throw new SysFactElectException("Role not found", HttpStatus.NOT_FOUND);
                }
            }
            userRepository.save(user);
        }else {
            throw new SysFactElectException("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<RoleByUserDTO> getRoles(UUID id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            return (List<RoleByUserDTO>) optionalUser.get().getRoles()
                    .stream()
                    .map(role -> roleToRoleByUserDTO.map(role))
                    .toList();
        }
        throw new SysFactElectException("User not found",HttpStatus.NOT_FOUND);
    }
}
