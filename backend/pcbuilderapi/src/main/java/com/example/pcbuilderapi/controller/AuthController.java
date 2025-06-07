package com.example.pcbuilderapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pcbuilderapi.dto.RegisterRequest;
import com.example.pcbuilderapi.model.User;
import com.example.pcbuilderapi.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest){
        User registeredUser = authService.register(registerRequest);
        return ResponseEntity.ok("User Registered Successfully! ID: " + registeredUser.getId());
    }


}
