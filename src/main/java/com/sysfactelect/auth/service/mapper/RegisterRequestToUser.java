package com.sysfactelect.auth.service.mapper;

import com.sysfactelect.admin.persistence.entity.Role;
import com.sysfactelect.admin.persistence.entity.RoleName;
import com.sysfactelect.admin.persistence.entity.User;
import com.sysfactelect.auth.service.mapper.DTO.RegisterRequest;
import com.sysfactelect.imapper.IMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RegisterRequestToUser implements IMapper<RegisterRequest, User> {
    @Override
    public User map(RegisterRequest in) {
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
