package com.smartc.smartc.controller;

import com.smartc.smartc.dto.LoginRequest;
import com.smartc.smartc.dto.LoginResponse;
import com.smartc.smartc.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}