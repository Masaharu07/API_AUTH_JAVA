package com.auth.api_auth_sozinho.service;

import com.auth.api_auth_sozinho.dtos.UserMeResponse;
import com.auth.api_auth_sozinho.model.User;
import com.auth.api_auth_sozinho.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserMeResponse getMe(String authHeader){
        if (authHeader == null || !authHeader.startsWith("Bearer ")){
            throw new RuntimeException("Token ausente");
        }
        String token = authHeader.substring("Bearer ".length()).trim();
        User user = userRepository.findByAuthToken(token)
                .orElseThrow(() -> new RuntimeException("Token inválido"));
        return new UserMeResponse(user.getId(), user.getUsername(), user.getEmail());
    }
}
