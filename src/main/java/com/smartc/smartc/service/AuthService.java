package com.smartc.smartc.service;

import com.smartc.smartc.dto.LoginRequest;
import com.smartc.smartc.dto.LoginResponse;
import com.smartc.smartc.entity.User;
import com.smartc.smartc.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return new LoginResponse(
                "Login successful",
                user.getUserId(),
                user.getName(),
                user.getRole()
        );
    }
}