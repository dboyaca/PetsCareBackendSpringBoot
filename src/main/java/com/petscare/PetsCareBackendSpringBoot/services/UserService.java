package com.petscare.PetsCareBackendSpringBoot.services;

import com.petscare.PetsCareBackendSpringBoot.repositories.UsersRepository;
import com.petscare.PetsCareBackendSpringBoot.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Users signUpUser(Users user){

        String rawPassword = user.getPassword();

        String encryptedPassword = passwordEncoder.encode(rawPassword);

        user.setPassword(encryptedPassword);

        return usersRepository.save(user);
    }





}
