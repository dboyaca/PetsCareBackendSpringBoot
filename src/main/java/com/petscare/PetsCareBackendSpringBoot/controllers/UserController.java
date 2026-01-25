package com.petscare.PetsCareBackendSpringBoot.controllers;


import com.petscare.PetsCareBackendSpringBoot.models.Patient;
import com.petscare.PetsCareBackendSpringBoot.models.Users;
import com.petscare.PetsCareBackendSpringBoot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
UserController will allow us to perform operations such as:
* Save and, as a result, associate a pet to a user
* The creation of users (Sign Up) is handled by the AuthController

 */
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/user/addPatient/{idUser}")
    public Users addPatientToUser(@PathVariable(name="idUser") Integer idUser, @RequestBody Patient newPatient){
        Users updatedUser = userService.createPatientForUser(idUser, newPatient);
        return updatedUser;
    }

    @GetMapping("/userPatients/{id}")
    public ResponseEntity<?> getUserPatients(@PathVariable Integer id) {
        // 1. Get the User
        Users user = userService.findById(id); // (Assumes you have a findById in UserService)

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        // 2. Return ONLY the list of patients
        // This is lighter than returning the whole User object
        return ResponseEntity.ok(user.getPatients());
    }
}
