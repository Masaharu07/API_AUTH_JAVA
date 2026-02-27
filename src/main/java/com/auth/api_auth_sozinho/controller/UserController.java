package com.auth.api_auth_sozinho.controller;

import com.auth.api_auth_sozinho.dtos.UserMeResponse;
import com.auth.api_auth_sozinho.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public UserMeResponse me(@RequestHeader("Authorization") String authHeader) {
        return userService.getMe(authHeader);
    }
}
