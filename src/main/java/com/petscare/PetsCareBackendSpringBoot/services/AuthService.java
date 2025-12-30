package com.petscare.PetsCareBackendSpringBoot.services;


import com.petscare.PetsCareBackendSpringBoot.models.Users;
import com.petscare.PetsCareBackendSpringBoot.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class AuthService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;

    }

    public Users authProcess(String email, String passwordIn){
        Users user = usersRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Now we proceed to compare passwords.
        // Take care with the injection of dependencies of the Bean Security Method passwordEncoder
        boolean matches = passwordEncoder.matches(passwordIn, user.getPassword());

        if(!matches){
            throw new RuntimeException("Incorrect Password");
        }

        return user;
    }

    public Users signUp(Users user) {
        //Validation that the email has not been registered before
        if (usersRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already taken");
        }

        //Encrypt the password that came in the JSON
        String plainPassword = user.getPassword();
        String encryptedPassword = passwordEncoder.encode(plainPassword);
        user.setPassword(encryptedPassword);

        //Overwrite the default values to ensure the user don't fake them
        user.setSignUpDate(LocalDateTime.now());
        user.setLastConnection(LocalDateTime.now());
        user.setOnline((byte) 1); // Set to 1 (True) since they just signed up/logged in

        return usersRepository.save(user);
    }

}
