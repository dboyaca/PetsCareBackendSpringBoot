package com.petscare.PetsCareBackendSpringBoot.services;

import com.petscare.PetsCareBackendSpringBoot.models.Patient;
import com.petscare.PetsCareBackendSpringBoot.repositories.PatientRepository;
import com.petscare.PetsCareBackendSpringBoot.repositories.UsersRepository;
import com.petscare.PetsCareBackendSpringBoot.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UsersRepository usersRepository;
    private final PatientRepository patientRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService (UsersRepository usersRepository, PasswordEncoder passwordEncoder, PatientRepository patientRepository){
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.patientRepository = patientRepository;
    }


    public Users signUpUser(Users user){

        String rawPassword = user.getPassword();

        String encryptedPassword = passwordEncoder.encode(rawPassword);

        user.setPassword(encryptedPassword);

        return usersRepository.save(user);
    }

    /*
    Since users have pets associated, we are going to create the service
    for creating pets and associate them to an user
     */
    public Users createPatientForUser(Integer userId, Patient newPatient){
        // In first place, we look up for the user that we will assign the pet or patient
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Next, we proceed to add the Patient
        Patient savedPatient = patientRepository.save(newPatient);

        /*
        Later, we proceed to add the patient to the users patient's list,
        remember that this is the way the ORM (Hibernate) take into account
        the relationship.
        * We use the add method since it is a list, not directly a repository.
         */
        user.getPatients().add(savedPatient);

        // We update the user with the information we just stored
        return usersRepository.save(user);

    }

    public Users findById(Integer userId) {
        return usersRepository.findById(userId).orElse(null);
    }










}
