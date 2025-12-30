package com.petscare.PetsCareBackendSpringBoot.controllers;

import com.petscare.PetsCareBackendSpringBoot.dtos.LoginRequest;
import com.petscare.PetsCareBackendSpringBoot.models.Users;
import com.petscare.PetsCareBackendSpringBoot.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){

        try{
            Users loggedUser = authService.authProcess(
                    request.getEmail(),
                    request.getPassword()
            );

            return ResponseEntity.ok(loggedUser);
        } catch (RuntimeException e){
            return ResponseEntity.status(401).body(e.getMessage());
        }

    }

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody Users user) {
        try {
            // Pass the model directly to the serviceYes
            Users createdUser = authService.signUp(user);
            return ResponseEntity.ok(createdUser);

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



}
