package com.auth.api_auth_sozinho.controller;

import com.auth.api_auth_sozinho.dtos.LoginRequest;
import com.auth.api_auth_sozinho.dtos.LoginResponse;
import com.auth.api_auth_sozinho.dtos.RegisterRequest;
import com.auth.api_auth_sozinho.dtos.UserMeResponse;
import com.auth.api_auth_sozinho.model.User;
import com.auth.api_auth_sozinho.repository.AuthRepository;
import com.auth.api_auth_sozinho.service.AuthService;
import com.auth.api_auth_sozinho.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService){this.authService = authService;}

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@Valid @RequestBody RegisterRequest req){authService.register(req);}

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public LoginResponse login(@Valid @RequestBody LoginRequest req){
        String token = authService.Login(req);
        return new LoginResponse(token);
    }
}
