package com.auth.api_auth_sozinho.dtos;

public class LoginResponse {
    public String token;
    public LoginResponse(String token){
        this.token = token;
    }
}
