package com.petscare.PetsCareBackendSpringBoot.dtos;

public class LoginRequest {

    private String email;
    private String password;

    // 1. Empty Constructor (Essential for Spring to create the object)
    public LoginRequest() {
    }

    // 2. Constructor with fields (Optional, but useful for testing)
    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // 3. Getters and Setters (REQUIRED: Without these, the values will be null)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
