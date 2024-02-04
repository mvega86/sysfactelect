package com.sysfactelect.auth.controller;

import com.sysfactelect.auth.service.IAuthService;
import com.sysfactelect.auth.service.mapper.DTO.AuthResponse;
import com.sysfactelect.auth.service.mapper.DTO.LoginRequest;
import com.sysfactelect.auth.service.mapper.DTO.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IAuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> resgister(@RequestBody RegisterRequest registerRequest){
        return ResponseEntity.ok(authService.register(registerRequest));
    }
}
