package com.sysfactelect.auth.service;

import com.sysfactelect.auth.service.mapper.dto.AuthResponse;
import com.sysfactelect.auth.service.mapper.dto.LoginRequest;
import com.sysfactelect.auth.service.mapper.dto.RegisterRequest;

public interface IAuthService {
    AuthResponse login(LoginRequest loginRequest);

    AuthResponse register(RegisterRequest registerRequest);
}
