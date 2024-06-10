package com.example.restfull_demo.controller;

import com.example.restfull_demo.dto.UpdateUserRequest;
import com.example.restfull_demo.dto.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/example")
@Slf4j
public class ExampleController {

    @GetMapping
    String greet(@RequestParam("username") String username) {
        return "hello " + username;
    }

    @GetMapping(path = "/{username}")
    String greetUser(@PathVariable("username") String username) {
        return "hello " + username;
    }

    @GetMapping(path = "/token")
    String greetUserFromHeader(@RequestHeader("Authorization") String authToken) {
        return "hello " + authToken;
    }

    @PostMapping(path = "/update/{customerId}")
    ResponseEntity<UserResponse> updateUser(@RequestBody UpdateUserRequest userRequest,
                                            @PathVariable("customerId") Long customerId,
                                            @RequestParam("param") String additionalParam) {
        // update user logic
        UserResponse response = new UserResponse();
        BeanUtils.copyProperties(userRequest, response);
        response.setStatus("Success");
        log.info("Customer with id {} was updated with status {}, additional param {}",customerId,response.getStatus(),additionalParam);
        return ResponseEntity.ok(response);
    }
}
