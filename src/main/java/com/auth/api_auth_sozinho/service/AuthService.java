package com.auth.api_auth_sozinho.service;

import com.auth.api_auth_sozinho.dtos.LoginRequest;
import com.auth.api_auth_sozinho.dtos.RegisterRequest;
import com.auth.api_auth_sozinho.dtos.UserMeResponse;
import com.auth.api_auth_sozinho.model.User;
import com.auth.api_auth_sozinho.repository.AuthRepository;
import com.auth.api_auth_sozinho.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthService{
    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(AuthRepository authRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.authRepository = authRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(RegisterRequest req){
        boolean exists = authRepository.findByEmail(req.email).isPresent();
        if (exists){
            throw new RuntimeException("Email já cadastrado...");
        }
        User user = new User();
        user.setUsername(req.username);
        user.setEmail(req.email);
        user.setPasswordHash(passwordEncoder.encode(req.password));
        authRepository.save(user);
    }

    public String Login(LoginRequest req){
        User user = authRepository.findByEmail(req.email)
                .orElseThrow(() -> new RuntimeException("Usuario ou senha incorretos"));
        boolean allowed = passwordEncoder.matches(req.password, user.getPasswordHash());
        if (!allowed){
            throw new RuntimeException("Usuario ou senha incorretos");
        }
        String token = UUID.randomUUID().toString();
        user.setAuthToken(token);
        authRepository.save(user);

        return token;
    }
}
