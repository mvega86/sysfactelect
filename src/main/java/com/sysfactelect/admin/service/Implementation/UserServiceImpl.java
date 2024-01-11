package com.sysfactelect.admin.service.Implementation;

import com.sysfactelect.admin.exceptions.SysFactElectException;
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
import com.sysfactelect.admin.service.mapper.DTO.RoleDTO;
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
    private CompanyRepository companyRepository;
    @Autowired
    private AddUserDTOToUser addUserDTOToUser;
    @Autowired
    private UserDTOToUser userDTOToUser;
    @Autowired
    private UserToUserDTO userToUserDTO;
    @Autowired
    private RoleToRoleDTO roleToRoleDTO;
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
    public void save(AddUserDTO addUserDTO) {
        Optional<Company> optionalCompany = companyRepository.findById(addUserDTO.getCompany().getId());
        if (optionalCompany.isPresent()){
            User user = addUserDTOToUser.map(addUserDTO);
            user.setCompany(optionalCompany.get());
            userRepository.save(user);
        }else {
            throw new SysFactElectException("Company not found", HttpStatus.NOT_FOUND);
        }
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
            UserDTO userDTO = userToUserDTO.map(optionalUser.get());
            userDTO.setUsername(addUserDTO.getUsername());
            userDTO.setPassword(addUserDTO.getPassword());
            userDTO.setEmail(addUserDTO.getEmail());
            userDTO.setName(addUserDTO.getName());
            userDTO.setLastname(addUserDTO.getLastname());
            userDTO.setCompany(addUserDTO.getCompany());
            userRepository.save(userDTOToUser.map(userDTO));
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
