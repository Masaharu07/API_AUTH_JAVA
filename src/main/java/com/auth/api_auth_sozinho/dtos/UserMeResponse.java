package com.auth.api_auth_sozinho.dtos;

import java.util.UUID;

public class UserMeResponse {
    public UUID id;
    public String username;
    public String email;

    public UserMeResponse(UUID id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }
}
