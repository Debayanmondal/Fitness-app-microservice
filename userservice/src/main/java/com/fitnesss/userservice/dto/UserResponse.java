package com.fitnesss.userservice.dto;

import com.fitnesss.userservice.model.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponse {
    private String id;
    private String keycloakId;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UserResponse(User user) {
        this.id=user.getId();
        this.keycloakId= user.getKeycloakId();
        this.email= user.getEmail();
        this.password= user.getPassword();
        this.firstName= user.getFirstName();
        this.lastName= user.getLastName();
        this.createdAt=user.getCreatedAt();
        this.updatedAt=user.getUpdatedAt();
    }
}
