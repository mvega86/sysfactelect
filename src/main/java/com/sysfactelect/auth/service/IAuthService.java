package com.sysfactelect.auth.service;

import com.sysfactelect.auth.service.mapper.DTO.AuthResponse;
import com.sysfactelect.auth.service.mapper.DTO.LoginRequest;
import com.sysfactelect.auth.service.mapper.DTO.RegisterRequest;

public interface IAuthService {

    AuthResponse login(LoginRequest loginRequest);

    AuthResponse register(RegisterRequest registerRequest);
}
