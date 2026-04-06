package com.fitnesss.userservice.service;


import com.fitnesss.userservice.dto.RegisterRequest;
import com.fitnesss.userservice.dto.UserResponse;
import com.fitnesss.userservice.model.User;
import com.fitnesss.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponse getUserProfile(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        UserResponse userResponse = new UserResponse(user);
        return userResponse;
    }

    public UserResponse register(RegisterRequest request) {

        if(userRepository.existsByEmail(request.getEmail())){
            User existinguser=userRepository.findByEmail(request.getEmail());
            UserResponse userResponse = new UserResponse(existinguser);
            return userResponse;
        }
        User user = new User();
        user.setEmail(request.getEmail());
        user.setKeycloakId(request.getKeycloakId());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());

        User saveduser=userRepository.save(user);
        UserResponse userResponse = new UserResponse(saveduser);
        return userResponse;
    }

    public Boolean existByUserId(String keycloakId) {
        return userRepository.existsByKeycloakId(keycloakId);
    }
}
