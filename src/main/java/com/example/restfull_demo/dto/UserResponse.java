package com.example.restfull_demo.dto;

import lombok.Data;

@Data
public class UserResponse {
    private String status;
    private String name;
    private String lastName;
    private String email;
}
