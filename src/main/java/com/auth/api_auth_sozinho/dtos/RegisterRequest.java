package com.auth.api_auth_sozinho.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class RegisterRequest {
    @NotBlank
    public String username;

    @NotBlank
    @Email
    public String email;

    @NotBlank
    public String password;
}
