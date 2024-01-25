package com.sysfactelect.admin.service.mapper;

import com.sysfactelect.admin.persistence.entity.User;
import com.sysfactelect.admin.service.mapper.DTO.AddUserDTO;
import com.sysfactelect.imapper.IMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AddUserDTOToUser implements IMapper<AddUserDTO, User> {
    @Override
    public User map(AddUserDTO in) {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername(in.getUsername());
        user.setEmail(in.getEmail());
        user.setPassword(in.getPassword());
        user.setName(in.getName());
        user.setLastname(in.getLastname());
        user.setCompany(in.getCompany());
        return user;
    }
}
