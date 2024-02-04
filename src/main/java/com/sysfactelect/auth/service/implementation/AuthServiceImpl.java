package com.sysfactelect.auth.service.implementation;

import com.sysfactelect.admin.persistence.entity.Role;
import com.sysfactelect.admin.persistence.entity.User;
import com.sysfactelect.admin.persistence.repository.RoleRepository;
import com.sysfactelect.admin.persistence.repository.UserRepository;
import com.sysfactelect.auth.service.IAuthService;
import com.sysfactelect.jwt.IJwtService;
import com.sysfactelect.auth.service.mapper.DTO.AuthResponse;
import com.sysfactelect.auth.service.mapper.DTO.LoginRequest;
import com.sysfactelect.auth.service.mapper.DTO.RegisterRequest;
import com.sysfactelect.auth.service.mapper.RegisterRequestToUser;
import com.sysfactelect.exceptions.SysFactElectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private IJwtService jwtService;
    @Autowired
    private RegisterRequestToUser registerRequestToUser;
    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public AuthResponse register(RegisterRequest registerRequest) {
        User user = registerRequestToUser.map(registerRequest);
        Optional<Role> optionalRole = roleRepository.findById(0L);
        if (optionalRole.isPresent()) {
            List<Role> roles = new ArrayList<>();
            roles.add(optionalRole.get());
            user.setRoles(roles);
            userRepository.save(user);
            return AuthResponse.builder()
                    .token(jwtService.getToken(user))
                    .build();
        }
        throw new SysFactElectException("Role not found", HttpStatus.NOT_FOUND);
    }
}
