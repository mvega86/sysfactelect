package com.sysfactelect.auth.service.implementation;

import com.sysfactelect.admin.persistence.entity.User;
import com.sysfactelect.admin.persistence.repository.UserRepository;
import com.sysfactelect.auth.service.IAuthService;
import com.sysfactelect.auth.service.mapper.RegisterRequestToUser;
import com.sysfactelect.auth.service.mapper.dto.AuthResponse;
import com.sysfactelect.auth.service.mapper.dto.LoginRequest;
import com.sysfactelect.auth.service.mapper.dto.RegisterRequest;
import com.sysfactelect.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements IAuthService {
    @Autowired
    private RegisterRequestToUser registerRequestToUser;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        Optional<User> optionalUser = userRepository.findByUsername(loginRequest.getUsername());
        if(optionalUser.isPresent()) {
            UserDetails user = optionalUser.get();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            System.out.println(user.getUsername());
            String token = jwtService.getToken(user);
            return AuthResponse.builder()
                    .token(token)
                    .build();
        }
        return null;
    }

    @Override
    public AuthResponse register(RegisterRequest registerRequest) {
        System.out.println(registerRequest.getUsername());
        User user = registerRequestToUser.map(registerRequest);
        userRepository.save(user);
        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
