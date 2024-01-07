package com.sysfactelect.admin.service.Implementation;

import com.sysfactelect.admin.exceptions.SysFactElectException;
import com.sysfactelect.admin.persistence.entity.User;
import com.sysfactelect.admin.persistence.repository.UserRepository;
import com.sysfactelect.admin.service.IUserService;
import com.sysfactelect.admin.service.mapper.AddUserDTOToUser;
import com.sysfactelect.admin.service.mapper.DTO.AddUserDTO;
import com.sysfactelect.admin.service.mapper.DTO.UserDTO;
import com.sysfactelect.admin.service.mapper.UserDTOToUser;
import com.sysfactelect.admin.service.mapper.UserToUserDTO;
import jakarta.persistence.EntityNotFoundException;
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
    private AddUserDTOToUser addUserDTOToUser;
    @Autowired
    private UserDTOToUser userDTOToUser;
    @Autowired
    private UserToUserDTO userToUserDTO;
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
        userRepository.save(addUserDTOToUser.map(addUserDTO));
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
}
