package com.petscare.PetsCareBackendSpringBoot.services;

import com.petscare.PetsCareBackendSpringBoot.models.Patient;
import com.petscare.PetsCareBackendSpringBoot.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService (PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    //This results problematic, since we have to associate it
    // to an specific user.
    /*
    public Patient addPatient(Patient patient){
        return this.patientRepository.save(patient);
    }
     */



    public Patient getPatientById(Integer idPatient){
        Optional<Patient> optionalValue = patientRepository.findById(idPatient);
        if(optionalValue.isEmpty()){
            return null;
        }
        return optionalValue.get();

    }

    public List<Patient> allPatients(){
        return this.patientRepository.findAll();
    }

    public Long totalNumberOfPatients(){
        return this.patientRepository.count();
    }

    public void deletePatientById(Integer idPatient){
        this.patientRepository.deleteById(idPatient);
    }



}
