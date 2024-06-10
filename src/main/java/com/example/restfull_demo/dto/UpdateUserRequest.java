package com.example.restfull_demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties()
public class UpdateUserRequest {
    private String name;
    private String lastName;
    private String email;
}
