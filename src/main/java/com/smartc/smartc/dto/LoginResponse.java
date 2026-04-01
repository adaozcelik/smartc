package com.smartc.smartc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponse {
    private String message;
    private Long userId;
    private String name;
    private String role;
}