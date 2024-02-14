package com.sysfactelect.auth.service.mapper;

import com.sysfactelect.admin.persistence.entity.User;
import com.sysfactelect.auth.service.mapper.dto.RegisterRequest;
import com.sysfactelect.imapper.IMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class RegisterRequestToUser implements IMapper<RegisterRequest, User> {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User map(RegisterRequest in) {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername(in.getUsername());
        user.setPassword(passwordEncoder.encode(in.getPassword()));
        user.setEmail(in.getEmail());
        user.setName(in.getName());
        user.setLastname(in.getLastname());
        user.setCompany(in.getCompany());
        return user;
    }
}
